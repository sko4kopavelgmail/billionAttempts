package skp.billionAttempts.model.education;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import skp.billionAttempts.model.utils.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "ba_study_subject")
public class StudySubject extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "studySubject", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WorkProgramme> workProgrammes;

}
