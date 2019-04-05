@Deprecated
public class NumberIsNotEqualTo extends BinaryNumberResultingInBooleanQuestion {
	private static Class[] s_supportedCoercionClasses = {NumberIsEqualTo.class, NumberIsGreaterThan.class, NumberIsGreaterThanOrEqualTo.class, NumberIsLessThan.class, NumberIsLessThanOrEqualTo.class};
	@Override
	public Class[] getSupportedCoercionClasses() {
		return s_supportedCoercionClasses;
	}
	@Override
	protected boolean getValue(double aValue, double bValue) {
		return aValue != bValue;
	}
}