package skp.billionAttempts.model.user.user_factory;

import skp.billionAttempts.model.user.Student;
import skp.billionAttempts.model.user.base_user.AbstractUser;
import skp.billionAttempts.model.user.base_user.Role;
import skp.billionAttempts.model.user.base_user.User;

import java.util.HashSet;
import java.util.Set;

public class StudentFactory implements UserFactory {

    @Override
    public AbstractUser createUser() {
        User user = new User();
        Set<Role> roles = new HashSet<>();
        roles.add(Role.STUDENT);
        roles.add(Role.USER);
        user.setRoles(roles);
        Student student = new Student();
        student.setUser(user);
        return student;
    }
}
