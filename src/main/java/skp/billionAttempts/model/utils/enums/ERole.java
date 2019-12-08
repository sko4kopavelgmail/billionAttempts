package skp.billionAttempts.model.utils.enums;

public enum ERole {
    ADMIN("ADMIN"), USER("USER"), STUDENT("STUDENT"), TEACHER("TEACHER");

    private String id;

    ERole(String id) {
        this.id = id;
    }

    public static ERole fromId(String id) {
        for (ERole role : ERole.values()) {
            if (role.getId().equals(id)) {
                return role;
            }
        }
        return null;
    }

    public String getId() {
        return id;
    }
}
