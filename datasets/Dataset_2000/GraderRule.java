public class GraderRule implements Serializable {
	private String gradeOrViewValue;
	private String selectedCategoryId;
	private String selectedSectionUuid;
	private Permission permission;
	public GraderRule() {
	}
	public void setPermission(Permission permission) {
		this.permission = permission;
	}
	public Permission getPermission() {
		return permission;
	}
	public void setGradeOrViewValue(String gradeOrViewValue) {
		this.gradeOrViewValue = gradeOrViewValue;
	}
	public String getGradeOrViewValue() {
		return gradeOrViewValue;
	}
	public void setSelectedCategoryId(String selectedCategoryId) {
		this.selectedCategoryId = selectedCategoryId;
	}
	public String getSelectedCategoryId() {
		return selectedCategoryId;
	}
	public void setSelectedSectionUuid(String selectedSectionUuid) {
		this.selectedSectionUuid = selectedSectionUuid;
	}
	public String getSelectedSectionUuid() {
		return selectedSectionUuid;
	}
}