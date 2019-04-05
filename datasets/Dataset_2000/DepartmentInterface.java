public interface DepartmentInterface extends EntityInterface,
		Comparable<DepartmentInterface> {
									ArrayList<UserInterface> GetMembers();
	public long GetId();
	public String GetName();
	public boolean SetName(String name);
	public String GetDescription();
	public boolean SetDescription(String description);
}