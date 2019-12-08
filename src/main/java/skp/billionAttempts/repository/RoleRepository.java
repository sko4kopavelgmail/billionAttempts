package skp.billionAttempts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import skp.billionAttempts.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
