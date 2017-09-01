package az.task.model;

/**
 * Role info .For now there is only 1 role .code:ROLE_USER,label:USER
 * */
public class Role {
    private Long roleId;
    private String code;
    private String label;

    public Role(Long roleId, String code, String label) {
        this.roleId = roleId;
        this.code = code;
        this.label = label;
    }
    public Role() {
    }
    /**
     * getters and setters
     * */

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
