package skp.billionAttempts.repository.uni_hierarchy;

import org.springframework.data.jpa.repository.JpaRepository;
import skp.billionAttempts.model.uni_hierarchy.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Faculty findByName(String facultyName);
}
