public class KimDocumentRoleResponsibilityActionId extends CompositePrimaryKeyBase {
	@Id
    @Column(name="FDOC_NBR")
    protected String documentNumber;
	@Id
	@Column(name="ROLE_RSP_ACTN_ID")
	protected String roleResponsibilityActionId;
	
	public String getDocumentNumber() {
		return this.documentNumber;
	}
	
	public String getRoleResponsibilityActionId() {
		return this.roleResponsibilityActionId;
	}
}