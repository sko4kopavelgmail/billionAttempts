package skp.billionAttempts.repository.education;

import org.springframework.data.jpa.repository.JpaRepository;
import skp.billionAttempts.model.education.CompetencyResult;

public interface CompetencyResultRepository extends JpaRepository<CompetencyResult, Long> {
}
