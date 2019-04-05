public class StaticDropDownParameter<T> extends ParameterDefinition<T> {
	public StaticDropDownParameter(String name, String label, Vector<T> allStaticValues, T defaultValue, boolean showReset) {
		this(name, label, allStaticValues, defaultValue);
		setShowReset(showReset);
	}
	public StaticDropDownParameter(String name, String label, Vector<T> allStaticValues, T defaultValue) {
		super(name, label, defaultValue);
		String allChoices = "";
		boolean isFirst = true;
		if (allStaticValues != null) {
			for (T next : allStaticValues) {
				allChoices += (!isFirst ? "," : "") + next;
				isFirst = false;
			}
		}
		addParameter("staticlist", allChoices);
	}
	@Override
	public String getWidgetName() {
		return DenaliWidget.DROPDOWN;
	}
	public void setShowReset(boolean showReset) {
		addParameter("showReset", "" + showReset);
	}
}