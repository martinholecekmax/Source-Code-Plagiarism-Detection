public class PortletPreferencesThreadLocal {
	public static boolean isStrict() {
		return _strict.get().booleanValue();
	}
	public static void setStrict(boolean strict) {
		_strict.set(strict);
	}
	private static ThreadLocal<Boolean> _strict =
		new InitialThreadLocal<Boolean>(
			PortletPreferencesThreadLocal.class + "._strict", false);
}