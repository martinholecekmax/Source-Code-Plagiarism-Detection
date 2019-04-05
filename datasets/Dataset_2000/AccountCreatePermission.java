public class AccountCreatePermission
    implements Permission
{
    private String id = "ACCOUNT-CREATE";
    private String description = "Account create permission - required to create a new account, allows anonymous users to register";
    private transient List<String> defaultRoles = new LinkedList<String>();
    public AccountCreatePermission()
    {
        defaultRoles.add( "anonymous" );
        defaultRoles.add( "member" );
        defaultRoles.add( "administrator" );
    }
    public String getId()
    {
        return id;
    }
    public String getDescription()
    {
        return description;
    }
    public boolean equals( Object permission )
    {
        return permission instanceof Permission && equals( (Permission) permission );
    }
    public boolean equals( Permission permission )
    {
        return id.equals( permission.getId() );
    }
    public List<String> getDefaultRoles()
    {
        return defaultRoles;
    }
}