public class BaseAdminObject
{
   @ConfigProperty(type = String.class, defaultValue = "InAO")
   private String myStringProperty;
   
   public void setMyStringProperty(String myStringProperty)
   {
      this.myStringProperty = myStringProperty;
   }
   
   public String getMyStringProperty()
   {
      return myStringProperty;
   }
}