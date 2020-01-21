package skp.billionAttempts.model.user;

import lombok.Getter;

@Getter
public enum Gender {

    MALE("M", "Male", "Мужской"),
    FEMALE("F", "Female", "Женский"),
    UNDETERMINED("U", "Undetermined", "Неопределенный");

    private String id;
    private String eName;
    private String rName;

    Gender(String id, String eName, String rName) {
        this.id = id;
        this.eName = eName;
        this.rName = rName;
    }

    public Gender fromId(String id) {
        for (Gender gender : Gender.values()) {
            if (gender.id.equals(id)) {
                return gender;
            }
        }
        return null;
    }
}
