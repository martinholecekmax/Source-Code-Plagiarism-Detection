public class JUnitTestRunnerTestCase
{
   @Test
   public void shouldReturnPassedTest() throws Exception 
   {
      JUnitTestRunner runner = new JUnitTestRunner();
      TestResult result = runner.execute(JUnitTestRunnerTestCase.class, "shouldProvidePassingTestToRunner");
      Assert.assertNotNull(result);
      Assert.assertEquals(TestResult.Status.PASSED, result.getStatus());
      Assert.assertNull(result.getThrowable());
   }
   @Test
   public void shouldReturnExceptionOnPassedTest() throws Exception 
   {
            Arquillian.caughtTestException.set(new IllegalArgumentException());
      JUnitTestRunner runner = new JUnitTestRunner();
      TestResult result = runner.execute(JUnitTestRunnerTestCase.class, "shouldProvideExpectedExceptionToRunner");
      Assert.assertNotNull(result);
      Assert.assertEquals(TestResult.Status.PASSED, result.getStatus());
      Assert.assertNotNull(result.getThrowable());
      Assert.assertEquals(IllegalArgumentException.class, result.getThrowable().getClass());
   }
   @Test(expected = IllegalArgumentException.class)
   public void shouldProvideExpectedExceptionToRunner() throws Exception
   {
      throw new IllegalArgumentException();
   }
   @Test
   public void shouldProvidePassingTestToRunner() throws Exception 
   {
      Assert.assertTrue(true);
   }
}