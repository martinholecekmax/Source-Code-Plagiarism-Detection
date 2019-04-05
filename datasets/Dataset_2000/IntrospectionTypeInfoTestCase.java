public class IntrospectionTypeInfoTestCase extends AbstractTypeInfoTest
{
   private TypeInfoFactory factory = new IntrospectionTypeInfoFactory();
   public IntrospectionTypeInfoTestCase(String name)
   {
      super(name);
   }
   public static Test suite()
   {
      return suite(IntrospectionTypeInfoTestCase.class);
   }
   protected TypeInfoFactory getTypeInfoFactory()
   {
      return factory;
   }
   protected boolean isTypeSupported()
   {
      return true;
   }
}