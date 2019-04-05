class NonFinalizingHotSwappingInvoker extends HotSwappingInvoker {
	public NonFinalizingHotSwappingInvoker(Class[] types, ProxyFactory proxyFactory, ObjectReference delegateReference,
			DelegationMode delegationMode) {
		super(types, proxyFactory, delegateReference, delegationMode);
	}
	private static final long serialVersionUID = 1L;
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if ("finalize".equals(method.getName()) && args != null && args.length == 0) {
			return null;
		}
		return super.invoke(proxy, method, args);
	}
}