package skp.billionAttempts.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import skp.billionAttempts.model.uni_hierarchy.StudyGroup;
import skp.billionAttempts.model.user.Student;
import skp.billionAttempts.model.user.base_user.User;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByStudyGroup(StudyGroup studyGroup);

    Student findByUser(User user);
}
