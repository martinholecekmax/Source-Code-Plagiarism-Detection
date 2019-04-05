public class TaskTask extends AbstractTask {
	private final String connectorKind;
	public TaskTask(String connectorKind, String repositoryUrl, String taskId) {
		super(repositoryUrl, taskId, ""); 		this.connectorKind = connectorKind;
		this.taskKey = taskId;
	}
	@Override
	public String getConnectorKind() {
		return connectorKind;
	}
	@Override
	public String getTaskKey() {
		return taskKey;
	}
	@Deprecated
	@Override
	public boolean isLocal() {
		return false;
	}
}