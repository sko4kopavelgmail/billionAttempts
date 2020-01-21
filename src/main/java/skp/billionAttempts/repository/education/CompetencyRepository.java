package skp.billionAttempts.repository.education;

import org.springframework.data.jpa.repository.JpaRepository;
import skp.billionAttempts.model.education.Competency;

public interface CompetencyRepository extends JpaRepository<Competency, Long> {
}
