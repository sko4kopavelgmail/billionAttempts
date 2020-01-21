package skp.billionAttempts.model.uni_hierarchy;

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
@Table(name = "ba_faculty")
public class Faculty extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Direction> directions;

    public Faculty(String name, List<Direction> directions) {
        this.name = name;
        this.directions = directions;
    }
}
