public class R2D2WQueryStringOperator extends ERD2WQueryStringOperator {
	
	private static final long serialVersionUID = 1L;
    private String labelID;
	public R2D2WQueryStringOperator(WOContext context) {
        super(context);
    }
	public void reset() {
		labelID = null;
		super.reset();
	}
	
	public String labelID() {
		if(labelID == null) {
			labelID = ERXStringUtilities.safeIdentifierName(context().elementID(),"id",'_');
		}
		return labelID;
	}
}