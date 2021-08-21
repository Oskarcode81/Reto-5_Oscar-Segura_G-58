package util;

public enum RequirementTypeEnum {

    REQUIREMENT_1("REQUIREMENT_1", "Requerimiento 1"),
    REQUIREMENT_2("REQUIREMENT_2", "Requerimiento 2"),
    REQUIREMENT_3("REQUIREMENT_3", "Requerimiento 3");

    private String code;
    private String description;

    RequirementTypeEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
