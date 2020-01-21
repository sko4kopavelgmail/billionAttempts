package skp.billionAttempts.repository.uni_hierarchy;

import org.springframework.data.jpa.repository.JpaRepository;
import skp.billionAttempts.model.uni_hierarchy.Direction;
import skp.billionAttempts.model.uni_hierarchy.StudyGroup;

import java.util.List;

public interface StudyGroupRepository extends JpaRepository<StudyGroup, Long> {
    StudyGroup findByName(String groupName);

    List<StudyGroup> findAllByDirection(Direction direction);
}
