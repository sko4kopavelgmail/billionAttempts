package skp.billionAttempts.service;

import skp.billionAttempts.model.user.base_user.User;

import java.util.List;

public interface UserService {
    User register(User user);

    List<User> getAll();

    User findByUsername(String username);

    User findById(Long id);

    void delete(Long id);
}