final class ManagedReferenceMethodInterceptorFactory implements InterceptorFactory {
    private final Object contextKey;
    private final Method method;
    ManagedReferenceMethodInterceptorFactory(final Object contextKey, final Method method) {
        this.contextKey = contextKey;
        this.method = method;
    }
    public Interceptor create(final InterceptorFactoryContext context) {
        @SuppressWarnings("unchecked")
        final AtomicReference<ManagedReference> ref = (AtomicReference<ManagedReference>) context.getContextData().get(contextKey);
        return new ManagedReferenceMethodInterceptor(ref, method);
    }
    static final class ManagedReferenceMethodInterceptor implements Interceptor {
        private final AtomicReference<ManagedReference> instanceRef;
        private final Method method;
        ManagedReferenceMethodInterceptor(final AtomicReference<ManagedReference> instanceRef, final Method method) {
            this.method = method;
            this.instanceRef = instanceRef;
        }
        
        public Object processInvocation(final InterceptorContext context) throws Exception {
            final ManagedReference reference = instanceRef.get();
            final Object instance = reference.getInstance();
            try {
                return method.invoke(instance, context.getParameters());
            } catch (IllegalAccessException e) {
                final IllegalAccessError n = new IllegalAccessError(e.getMessage());
                n.setStackTrace(e.getStackTrace());
                throw n;
            } catch (InvocationTargetException e) {
                throw Interceptors.rethrow(e.getCause());
            }
        }
    }
}