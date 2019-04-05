public interface GenAuditRule extends GenRuleBase {
	
	GenAuditRoot getRoot();
	
	String getId();
	
	void setId(String value);
	
	String getMessage();
	
	void setMessage(String value);
	
	GenConstraint getRule();
	
	void setRule(GenConstraint value);
	
	GenAuditable getTarget();
	
	void setTarget(GenAuditable value);
	
	GenSeverity getSeverity();
	
	void setSeverity(GenSeverity value);
	
	boolean isUseInLiveMode();
	
	void setUseInLiveMode(boolean value);
	
	boolean isRequiresConstraintAdapter();
	
	GenAuditContainer getCategory();
	
	void setCategory(GenAuditContainer value);
	
	String getConstraintAdapterQualifiedClassName();
	String getConstraintAdapterLocalClassName();
	String getConstraintAdapterClassName();
}