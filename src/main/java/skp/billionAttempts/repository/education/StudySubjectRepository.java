package skp.billionAttempts.repository.education;

import org.springframework.data.jpa.repository.JpaRepository;
import skp.billionAttempts.model.education.StudySubject;

public interface StudySubjectRepository extends JpaRepository<StudySubject, Long> {
}
