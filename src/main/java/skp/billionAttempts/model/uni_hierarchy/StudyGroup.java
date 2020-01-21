package skp.billionAttempts.model.uni_hierarchy;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import skp.billionAttempts.model.user.Student;
import skp.billionAttempts.model.user.Teacher;
import skp.billionAttempts.model.utils.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "ba_study_group")
public class StudyGroup extends BaseEntity {

    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "direction_id")
    private Direction direction;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "studyGroup")
    private List<Student> students;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "studyGroup")
    private List<Teacher> teachers;

}