public abstract class TaskFromDBHandler implements Runnable
{
	protected int		id;
	protected String	params[];
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public void setParam(String params[])
	{
		this.params = params;
	}
	
	public abstract String getTaskName();
	
	public abstract boolean isValid();
	
	protected void setLastActivation()
	{
		DAOManager.getDAO(TaskFromDBDAO.class).setLastActivation(id);
	}
}