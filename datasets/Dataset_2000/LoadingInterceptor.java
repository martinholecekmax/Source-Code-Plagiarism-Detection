public class LoadingInterceptor implements MethodInterceptor {
	@Inject
	private Console console;
	public Object invoke(final MethodInvocation invocation) throws Throwable {
		console.printf("Loading..\n");
		final Object returnValue = invocation.proceed();
		console.printf("Done.\n");
		return returnValue;
	}
}