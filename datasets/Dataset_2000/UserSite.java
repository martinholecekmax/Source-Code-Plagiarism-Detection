@PrimaryType(name = "mop:usersite")
public abstract class UserSite extends SiteImpl<UserSiteContainer>
{
      public ObjectType<? extends Site> getObjectType()
   {
      return ObjectType.USER_SITE;
   }
}