@SuppressWarnings("serial")
public class LoadableTaskModel extends LoadableDetachableModel<Task> {
    private final String taskId;
    private final TaskboxService taskboxService;
    public LoadableTaskModel(String taskId, TaskboxService taskboxService) {
        this.taskId = taskId;
        this.taskboxService = taskboxService;
    }
    @Override
    protected Task load() {
        try {
            return taskboxService.getTaskForId(taskId);
        } catch (TaskboxException e) {
            return null;
        }
    }
}