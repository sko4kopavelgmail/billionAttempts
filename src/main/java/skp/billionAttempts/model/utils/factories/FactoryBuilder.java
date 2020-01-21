package skp.billionAttempts.model.utils.factories;

import skp.billionAttempts.model.user.user_factory.StudentFactory;
import skp.billionAttempts.model.user.user_factory.TeacherFactory;
import skp.billionAttempts.model.user.user_factory.UserFactory;

public class FactoryBuilder {

    public static UserFactory getUserFactory(Object o) {
        if (o instanceof StudentFactory) {
            return new StudentFactory();
        } else if (o instanceof TeacherFactory) {
            return new TeacherFactory();
        } else {
            throw new RuntimeException(o + "is unknown user factory");
        }

    }

}
