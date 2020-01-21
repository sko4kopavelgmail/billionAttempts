package skp.billionAttempts.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import skp.billionAttempts.model.user.base_user.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
