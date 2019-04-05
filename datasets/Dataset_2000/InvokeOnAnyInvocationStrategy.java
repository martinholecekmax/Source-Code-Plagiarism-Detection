public class InvokeOnAnyInvocationStrategy extends InvokeOnNextInvocationStrategy
{
	private static Logger logger = LoggerFactory.getLogger(InvokeOnExistingInvocationStrategy.class);
	
	@Override
	public <Z, D extends Database<Z>, T, R, E extends Exception> SortedMap<D, R> invoke(SQLProxy<Z, D, T, E> proxy, Invoker<Z, D, T, R, E> invoker) throws E
	{
		DatabaseCluster<Z, D> cluster = proxy.getDatabaseCluster();
		Dialect dialect = cluster.getDialect();
		StateManager stateManager = cluster.getStateManager();
		ExceptionFactory<E> exceptionFactory = proxy.getExceptionFactory();
		for (Map.Entry<D, T> entry: proxy.entries())
		{
			D database = entry.getKey();
			try
			{
				R result = invoker.invoke(database, entry.getValue());
				return Collections.singletonSortedMap(database, result);
			}
			catch (Exception e)
			{
				E exception = exceptionFactory.createException(e);
				if (exceptionFactory.indicatesFailure(exception, dialect) && (cluster.getBalancer().size() > 1))
				{
					if (cluster.deactivate(database, stateManager))
					{
						logger.error( Messages.DATABASE_DEACTIVATED.getMessage(), database, cluster);
					}
				}
				else
				{
					throw exception;
				}
			}
		}
		return super.invoke(proxy, invoker);
	}
}