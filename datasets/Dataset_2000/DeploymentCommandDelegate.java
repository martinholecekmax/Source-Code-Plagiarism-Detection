public class DeploymentCommandDelegate implements ActionCell.Delegate<DeploymentRecord> {
    private DeploymentCommand command;
    private DeployCommandExecutor executor;
    
    public DeploymentCommandDelegate(DeployCommandExecutor executor, DeploymentCommand command) {
        this.command = command;
        this.executor = executor;
    }
    @Override
    public void execute(DeploymentRecord record) {
        command.execute(executor, record);
    }
}