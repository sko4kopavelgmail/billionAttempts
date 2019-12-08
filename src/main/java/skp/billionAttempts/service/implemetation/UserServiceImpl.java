package skp.billionAttempts.service.implemetation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import skp.billionAttempts.model.User;
import skp.billionAttempts.model.utils.enums.ERole;
import skp.billionAttempts.model.utils.enums.EStatus;
import skp.billionAttempts.repository.RoleRepository;
import skp.billionAttempts.repository.UserRepository;
import skp.billionAttempts.service.UserService;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(User user) {
        user.setRoles(Collections.singletonList(roleRepository.findByName(ERole.USER.getId())));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setStatus(EStatus.ACTIVE);

        User registeredUser = userRepository.save(user);

        log.info("UserServiceImpl.register; {} successfully registered", registeredUser);

        return registeredUser;
    }

    @Override
    public List<User> getAll() {
        List<User> users = userRepository.findAll();
        log.info("UserServiceImpl.getAll; {} users found", users.size());
        return users;
    }

    @Override
    public User findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (Objects.isNull(user)) {
            log.info("UserServiceImpl.findByUsername; no user found by username: {}", username);
        } else {
            log.info("UserServiceImpl.findByUsername; user: {} found by username: {}", user, username);
        }
        return user;
    }

    @Override
    public User findById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (Objects.isNull(user)) {
            log.info("UserServiceImpl.findById; no user found by id: {}", id);
        } else {
            log.info("UserServiceImpl.findById; user: {} found by id: {}", user, id);
        }
        return user;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
        log.info("UserServiceImpl.delete; user with id: {} has been deleted", id);
    }
}
