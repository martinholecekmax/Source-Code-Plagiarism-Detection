public final class TimingActivityHelper {
	private static final String ACTIVITY_OPTION_FOR = "for";
	private static final String ACTIVITY_OPTION_UNTIL = "until";
	private TimingActivityHelper() {
	}
	public void setFor(Element activity, String durationExpression) {
		List<Element> timeExpressions = XMLUtil.getChildElementsByName(activity, ACTIVITY_OPTION_FOR);
		timeExpressions.addAll(XMLUtil.getChildElementsByName(activity, ACTIVITY_OPTION_UNTIL));
		Document document = activity.getOwnerDocument();
		Element newFor = document.createElementNS(activity.getNamespaceURI(), ACTIVITY_OPTION_FOR);
		Text newDuration = document.createTextNode(durationExpression);
		newFor.appendChild(newDuration);
		if(timeExpressions.size() > 0) {
			activity.replaceChild(newFor, timeExpressions.get(0));
		} else {
			XMLUtil.addAsFirstChild(activity, newFor);
		}
	}
}