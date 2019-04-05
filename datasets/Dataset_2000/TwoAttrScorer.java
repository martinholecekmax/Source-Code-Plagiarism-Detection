public abstract class TwoAttrScorer extends Scorer {
	private static final long serialVersionUID = -2774223535588569867L;
	protected int otherAttrId;
    public TwoAttrScorer( int scoreAttrId, int otherAttrId ) {
        super( scoreAttrId );
		Assert.state(otherAttrId != 0, "otherAttrId must be defined");
        this.otherAttrId = otherAttrId;
    }
    public int getOtherAttrId() {
        return otherAttrId;
    }
	@Override
	protected void assertValidInternal() {
		Assert.state(otherAttrId != 0, "otherAttrId must be defined");
	}
}