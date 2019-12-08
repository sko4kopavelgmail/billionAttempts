package skp.billionAttempts.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import skp.billionAttempts.model.User;
import skp.billionAttempts.security.jwt.JwtUser;
import skp.billionAttempts.security.jwt.JwtUserFactory;
import skp.billionAttempts.service.UserService;

import java.util.Objects;

@Slf4j
@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public JwtUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);

        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("User with username: " + username + " not found");
        }

        JwtUser jwtUser = JwtUserFactory.create(user);
        log.info("JwtUserDetailsService.loadUserByUsername; user with username: {} successfully loaded", username);

        return jwtUser;
    }
}