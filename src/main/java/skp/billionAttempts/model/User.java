package skp.billionAttempts.model;

import lombok.Data;
import skp.billionAttempts.model.utils.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "ba_user")
public class User extends BaseEntity {

    private String username;

    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ba_user_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;

}
