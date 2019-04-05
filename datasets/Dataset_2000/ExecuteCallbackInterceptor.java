class ExecuteCallbackInterceptor<T> implements ExecutionInterceptor<T>
{
    @Override
    public T execute(ExecutionCallback<T> callback) throws Exception
    {
        return callback.process();
    }
}