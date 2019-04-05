public abstract class TaskFromDBDAO implements DAO
{
	
	public abstract ArrayList<TaskFromDB> getAllTasks();
	
	public abstract void setLastActivation(final int id);
	
	@Override
	public final String getClassName()
	{
		return TaskFromDBDAO.class.getName();
	}
}