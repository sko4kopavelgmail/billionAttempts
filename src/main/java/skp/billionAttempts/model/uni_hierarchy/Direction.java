package skp.billionAttempts.model.uni_hierarchy;

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
@Table(name = "ba_direction")
public class Direction extends BaseEntity {

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @OneToMany(mappedBy = "direction", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StudyGroup> groups;

    public Direction(String name, Faculty faculty) {
        this.name = name;
        this.faculty = faculty;
    }
}
