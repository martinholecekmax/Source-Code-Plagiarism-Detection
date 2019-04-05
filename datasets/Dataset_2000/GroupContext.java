class GroupContext
{
	
	private String group;
	
	private long id;
	
	GroupContext(String group, long id)
	{
		this.group = group;
		this.id = id;
	}
	
	long getId() { return id; }
	
	public String toString() { return group; }
}