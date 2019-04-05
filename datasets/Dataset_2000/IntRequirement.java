public class IntRequirement extends Requirement {
	private IntegerMatcher matcher;
	
	public IntRequirement(String value, String propertyName) {
		super(value, propertyName);
		if (this.needsToBeUndefined) {
			return;
		}
		try {
			this.matcher = new IntegerMatcher( value );
		} catch (NumberFormatException e) {
			throw new BuildException("Unable to create int-requirement for value [" + value + "]: " + e );
		}
	}
	
	protected boolean isMet(Device device, String property) {
		return this.matcher.matches( property );
	}
}