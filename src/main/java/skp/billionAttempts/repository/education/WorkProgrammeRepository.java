package skp.billionAttempts.repository.education;

import org.springframework.data.jpa.repository.JpaRepository;
import skp.billionAttempts.model.education.WorkProgramme;

public interface WorkProgrammeRepository extends JpaRepository<WorkProgramme, Long> {
}
