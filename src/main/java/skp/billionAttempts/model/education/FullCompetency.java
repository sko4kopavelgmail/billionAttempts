package skp.billionAttempts.model.education;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import skp.billionAttempts.model.utils.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ba_full_competency")
public class FullCompetency extends BaseEntity{

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "competency_id")
    private Competency competency;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "competency_result_id")
    private CompetencyResult competencyResult;

    @OneToMany(mappedBy = "fullCompetency", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WorkProgramme> workProgrammes;

}
