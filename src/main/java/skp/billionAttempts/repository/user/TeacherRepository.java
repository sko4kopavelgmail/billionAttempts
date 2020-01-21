package skp.billionAttempts.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import skp.billionAttempts.model.uni_hierarchy.StudyGroup;
import skp.billionAttempts.model.user.Teacher;
import skp.billionAttempts.model.user.base_user.User;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findAllByStudyGroup(StudyGroup studyGroup);

    Teacher findByUser(User user);
}
