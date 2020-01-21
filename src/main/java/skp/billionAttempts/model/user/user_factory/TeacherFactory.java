package skp.billionAttempts.model.user.user_factory;

import skp.billionAttempts.model.user.Teacher;
import skp.billionAttempts.model.user.base_user.AbstractUser;
import skp.billionAttempts.model.user.base_user.Role;
import skp.billionAttempts.model.user.base_user.User;

import java.util.HashSet;
import java.util.Set;

public class TeacherFactory implements UserFactory {

    @Override
    public AbstractUser createUser() {
        User user = new User();
        Set<Role> roles = new HashSet<>();
        roles.add(Role.USER);
        roles.add(Role.TEACHER);
        user.setRoles(roles);
        Teacher teacher = new Teacher();
        teacher.setUser(user);
        return teacher;
    }
}
