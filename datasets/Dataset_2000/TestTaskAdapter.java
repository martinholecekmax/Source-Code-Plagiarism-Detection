public class TestTaskAdapter
    extends TestCase
{
    private TaskAdapter     target;      private MockExecCommand task;      public void setUp()
    {
        task = new MockExecCommand();
        target = new TaskAdapter(task);
    }
    public void testTaskAdapter()
    {
        try {
            new TaskAdapter(null);
            fail("TaskAdapter shouldn't accept null.");
        } catch (NullPointerException npe) {
                    }
    }
    public void testIsDone() 
        throws Exception
    {
                task.run();
                task.activate();
                assertFalse("Before doStep we're not done!", target.isDone());
        target.doStep();
        assertTrue("After doStep we're done!", target.isDone());
        target.doStep();
        assertTrue("After the fisrt doStep we're done!", target.isDone());
                task.verify();
    }
    public void testDoStep() 
        throws Exception
    {
                task.run();
                task.activate();
                target.doStep();
        target.doStep();                  task.verify();
    }
}