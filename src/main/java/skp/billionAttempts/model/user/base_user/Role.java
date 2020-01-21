package skp.billionAttempts.model.user.base_user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import skp.billionAttempts.model.utils.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public enum  Role implements GrantedAuthority{
    ADMIN("ADMIN", "Администратор", "Admin"),
    USER("USER", "Пользователь", "User"),
    STUDENT("STUDENT", "Студент", "Student"),
    TEACHER("TEACHER", "Преподаватель", "Teacher");

    private String id;
    private String rName;
    private String eName;

    Role(String id, String rName, String eName) {
        this.id = id;
        this.eName = eName;
        this.rName = rName;
    }

    public static Role fromId(String id) {
        for (Role role : Role.values()) {
            if (role.getId().equals(id)) {
                return role;
            }
        }
        return null;
    }

    public static List<Role> getRolesExceptUser() {
        return Arrays.stream(Role.values()).filter(role -> !role.getId().equals(USER.id)).collect(Collectors.toList());
    }

    @Override
    public String getAuthority() {
        return id;
    }
}
