public class KaleoDefinitionServiceClpInvoker {
	public KaleoDefinitionServiceClpInvoker() {
		_methodName80 = "getBeanIdentifier";
		_methodParameterTypes80 = new String[] {  };
		_methodName81 = "setBeanIdentifier";
		_methodParameterTypes81 = new String[] { "java.lang.String" };
		_methodName86 = "getKaleoDefinitions";
		_methodParameterTypes86 = new String[] { "int", "int" };
		_methodName87 = "getKaleoDefinitions";
		_methodParameterTypes87 = new String[] { "long", "int", "int" };
	}
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName80.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
			return KaleoDefinitionServiceUtil.getBeanIdentifier();
		}
		if (_methodName81.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
			KaleoDefinitionServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);
			return null;
		}
		if (_methodName86.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes86, parameterTypes)) {
			return KaleoDefinitionServiceUtil.getKaleoDefinitions(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}
		if (_methodName87.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes87, parameterTypes)) {
			return KaleoDefinitionServiceUtil.getKaleoDefinitions(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}
		throw new UnsupportedOperationException();
	}
	private String _methodName80;
	private String[] _methodParameterTypes80;
	private String _methodName81;
	private String[] _methodParameterTypes81;
	private String _methodName86;
	private String[] _methodParameterTypes86;
	private String _methodName87;
	private String[] _methodParameterTypes87;
}