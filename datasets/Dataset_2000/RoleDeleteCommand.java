@Command(scope = "jaas", name = "role-delete", description = "Delete a role from a user")
public class RoleDeleteCommand extends JaasCommandSupport {
    @Argument(index = 0, name = "username", description = "User Name", required = true, multiValued = false)
    private String username;
    @Argument(index = 1, name = "role", description = "Role", required = true, multiValued = false)
    private String role;
    
    @Override
    protected Object doExecute(BackingEngine engine) throws Exception {
        engine.deleteRole(username, role);
        return null;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    @Override
    public String toString() {
        return "RoleDeleteCommand{" +
                "username='" + username + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}