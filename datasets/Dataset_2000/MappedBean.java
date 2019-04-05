public class MappedBean extends HashMap {
   private static final long serialVersionUID = -3372716996620968313L;
   public List getList() {
      return (List) get( "list" );
   }
   public String getName() {
      return (String) get( "name" );
   }
   public void setList( List list ) {
      put( "list", list );
   }
   public void setName( String name ) {
      put( "name", name );
   }
}