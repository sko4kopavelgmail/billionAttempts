package skp.billionAttempts.model.education;

import lombok.Getter;

@Getter
public enum CompetencyResultType {
    KNOW("KNOW", "To Know", "Знать"),
    APPLY("APPLY", "Be able to apply the knowledge", "Уметь"),
    SKILLS("SKILLS", "Have some skills", "Владеть");


    private String id;
    private String eName;
    private String rName;

    CompetencyResultType(String id, String eName, String rName) {
        this.id = id;
        this.eName = eName;
        this.rName = rName;
    }

    public CompetencyResultType fromId(String id) {
        for (CompetencyResultType type : CompetencyResultType.values()) {
            if (type.id.equals(id)) {
                return type;
            }
        }
        return null;
    }

}
