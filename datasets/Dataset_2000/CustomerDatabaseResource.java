@Path("/customers")
public class CustomerDatabaseResource
{
   protected CustomerResource europe = new CustomerResource();
   protected FirstLastCustomerResource northamerica = new FirstLastCustomerResource();
   @Path("{database}-db")
   public Object getDatabase(@PathParam("database") String db)
   {
      if (db.equals("europe"))
      {
         return europe;
      }
      else if (db.equals("northamerica"))
      {
         return northamerica;
      }
      else return null;
   }
}