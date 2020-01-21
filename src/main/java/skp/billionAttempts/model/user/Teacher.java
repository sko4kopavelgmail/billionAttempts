package skp.billionAttempts.model.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import skp.billionAttempts.model.uni_hierarchy.StudyGroup;
import skp.billionAttempts.model.user.base_user.AbstractUser;
import skp.billionAttempts.model.user.base_user.User;
import skp.billionAttempts.model.utils.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "ba_teacher")
@NoArgsConstructor
@Getter
@Setter
public class Teacher extends BaseEntity implements AbstractUser {

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "study_group_id")
    private StudyGroup studyGroup;

}
