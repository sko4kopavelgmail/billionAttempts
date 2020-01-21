package skp.billionAttempts.model.education;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class WorkProgramme {

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "study_subject_id")
    private StudySubject studySubject;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "full_competency_id")
    private FullCompetency fullCompetency;

}
