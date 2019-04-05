public class WorkflowLogResetter extends WorkflowSwitch<Boolean>
{
	public WorkflowLogResetter(WorkflowContext context)
	{
		this.context = context;
	}
	@Override
	public Boolean caseWorkflowCompositeComponent(WorkflowCompositeComponent object)
	{
		context.clearLog(object);
		for(WorkflowComponent component : object.getComponents())
			doSwitch(component);
		return Boolean.TRUE;
	}
	@Override
	public Boolean caseWorkflowUnitOfWork(WorkflowUnitOfWork object)
	{
		context.clearLog(object);
		return Boolean.TRUE;
	}
	private WorkflowContext context;
}