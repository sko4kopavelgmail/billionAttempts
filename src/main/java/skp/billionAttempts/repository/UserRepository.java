package skp.billionAttempts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import skp.billionAttempts.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);
}
