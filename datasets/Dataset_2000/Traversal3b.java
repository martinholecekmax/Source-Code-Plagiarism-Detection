public class Traversal3b extends Traversal3a {
	public Traversal3b(Setup oo7setup) {
		super(oo7setup);
	}
	@Override
	protected int performOperationInAtomicPart(AtomicPart part, HashSet<AtomicPart> setOfVisitedPartIds) {
		updateBuildDate(part);
		return 1;
    }
    @Override
    public OperationId getOperationId() {
    	return OperationId.T3b;
    }
}