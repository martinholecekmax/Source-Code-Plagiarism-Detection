public class RoleQueryImpl extends AbstractQuery implements RoleQuery
{
   public final User user;
   public final Group group;
   public final RoleType roleType;
   public RoleQueryImpl(IdentitySearchCriteriaImpl searchCriteria, User user, Group group, RoleType roleType)
   {
      super(searchCriteria);
      this.user = user;
      this.group = group;
      this.roleType = roleType;
   }
   @Override
   public boolean equals(Object o)
   {
      if (this == o)
      {
         return true;
      }
      if (!(o instanceof RoleQueryImpl))
      {
         return false;
      }
      if (!super.equals(o))
      {
         return false;
      }
      RoleQueryImpl roleQuery = (RoleQueryImpl)o;
      if (group != null ? !group.equals(roleQuery.group) : roleQuery.group != null)
      {
         return false;
      }
      if (roleType != null ? !roleType.equals(roleQuery.roleType) : roleQuery.roleType != null)
      {
         return false;
      }
      if (user != null ? !user.equals(roleQuery.user) : roleQuery.user != null)
      {
         return false;
      }
      return true;
   }
   @Override
   public int hashCode()
   {
      int result = super.hashCode();
      result = 31 * result + (user != null ? user.hashCode() : 0);
      result = 31 * result + (group != null ? group.hashCode() : 0);
      result = 31 * result + (roleType != null ? roleType.hashCode() : 0);
      return result;
   }
}