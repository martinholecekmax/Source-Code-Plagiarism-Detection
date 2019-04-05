public class SessionExportSystemViewOutputStreamTest
   extends AbstractContentCreatorForExportTest
{
   @Override
   public void doRun(TestCase tc, JCRTestContext context) throws Exception
   {
      context.getSession().exportDocumentView(nextPath(), nextOutputStream(), false, false);
   }
}