public class TaskServiceEventMessagingLocalSyncTest extends TaskServiceEventMessagingBaseSyncTest {
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        client = new LocalTaskService(taskService);
    }
}