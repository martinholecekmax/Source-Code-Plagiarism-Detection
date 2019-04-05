public class BehaviourInjector_ForExample5 {
	public IFrontLoader_Role assignRolesMagically(Project_Data project) {
										FrontLoaderRole fl = new FrontLoaderRole();
		for(Task_Data t : project.getTasks()){
			IActivity_Role a = new ActivityRole(t);
			fl.getActivities().add(a);
		}
		return fl;
	}
	private static class FrontLoaderRole implements IFrontLoader_Role {
		private List<IActivity_Role> activities = new ArrayList<IActivity_Role>();
		@Override
		public List<IActivity_Role> getActivities() {
			return activities;
		}
	}
	private static class ActivityRole implements IActivity_Role {
		private Task_Data task;
		public ActivityRole(Task_Data task){
			this.task = task;
		}
		@Override
		public Date getEnd() {
			return task.getEnd();
		}
		@Override
		public List<IActivity_Role> getPredecessors() {
			List<IActivity_Role> ps = new ArrayList<IActivity_Role>();
			for(Task_Data t : task.getDependencies()){
				ps.add(new ActivityRole(t));
			}
			return ps;
		}
		@Override
		public boolean hasBeenPlanned() {
			return task.hasBeenPlanned();
		}
		@Override
		public String getId() {
			return task.getId();
		}
		@Override
		public void setStart(Date start) {
			task.setStart(start);
		}
		@Override
		public Date getStart() {
			return task.getStart();
		}
	}
}