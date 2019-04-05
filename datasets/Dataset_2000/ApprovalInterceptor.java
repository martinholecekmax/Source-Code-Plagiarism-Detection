public class ApprovalInterceptor implements MethodInterceptor {
    @Autowired
    MethodInvocationHandler invocationHandler;
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        if(invocation.getMethod().isAnnotationPresent(RequestMapping.class)) {
            RequestMapping requestMapping = (RequestMapping) invocation.getMethod().getAnnotations()[0];
            if(requestMapping.method()[0] != RequestMethod.GET) {
                return invocationHandler.process(invocation);
            }
        }
        return invocation.proceed();
    }
}