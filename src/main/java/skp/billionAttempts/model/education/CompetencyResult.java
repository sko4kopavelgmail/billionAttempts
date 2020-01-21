package skp.billionAttempts.model.education;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import skp.billionAttempts.model.utils.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "ba_competency_result")
public class CompetencyResult extends BaseEntity {

    private String value;

    @Enumerated(EnumType.STRING)
    @Column(name = "competency_type")
    private CompetencyResultType competencyResultType;

    @OneToMany(mappedBy = "competencyResult", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FullCompetency> fullCompetencies;
}
