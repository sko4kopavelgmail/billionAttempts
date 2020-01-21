package skp.billionAttempts.repository.uni_hierarchy;

import org.springframework.data.jpa.repository.JpaRepository;
import skp.billionAttempts.model.uni_hierarchy.Direction;
import skp.billionAttempts.model.uni_hierarchy.Faculty;

import java.util.List;

public interface DirectionRepository extends JpaRepository<Direction, Long> {
    Direction findByName(String directionName);

    List<Direction> findAllByFaculty(Faculty faculty);
}
