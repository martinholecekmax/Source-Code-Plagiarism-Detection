public class OrganizationListCommand implements Serializable {
	
	private static final long serialVersionUID = -5193621639155333889L;
	protected String nameFilter;
	protected String orgType;
	public String getNameFilter() {
		return nameFilter;
	}
	public void setNameFilter(String nameFilter) {
		this.nameFilter = nameFilter;
	}
	public String getOrgType() {
		return orgType;
	}
	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}
}