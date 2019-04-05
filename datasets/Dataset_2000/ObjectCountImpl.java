public class ObjectCountImpl extends ObjectBasedExpressionImpl implements ObjectCount {
	
	protected ObjectCountImpl() {
		super();
	}
	
	@Override
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.OBJECT_COUNT;
	}
}