@ConfiguredBy({})
public class KernelRuleClassScopedTestCase
{
   @ClassRule
   public static KernelLifeCycle kernel = new KernelLifeCycle();
   
   private PortalContainer container;
   @Test
   public void testA()
   {
      if (container == null)
      {
         container = kernel.getContainer();
      }
      else
      {
         assertSame(container, kernel.getContainer());
      }
   }
   @Test
   public void testB() throws Exception
   {
      testA();
   }
}