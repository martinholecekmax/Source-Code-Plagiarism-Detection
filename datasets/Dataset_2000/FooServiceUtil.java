public class FooServiceUtil {
	
	
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}
	
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}
	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}
	public static com.liferay.portal.model.User getUser(long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUser(userId);
	}
	public static void clearService() {
		_service = null;
	}
	public static FooService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					FooService.class.getName());
			if (invokableService instanceof FooService) {
				_service = (FooService)invokableService;
			}
			else {
				_service = new FooServiceClp(invokableService);
			}
			ReferenceRegistry.registerReference(FooServiceUtil.class, "_service");
		}
		return _service;
	}
	
	public void setService(FooService service) {
	}
	private static FooService _service;
}