package az.task.model;

/**
 * Account info
 * */
public class Account  {
    private Long accountId;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private Role role;

    public Account() {
    }
    public Account(Long accountId, String username, String firstName, String lastName, String password) {
        this.accountId = accountId;
        this.email = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }
    /**
     *
     * getters &setters
     * */
    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
