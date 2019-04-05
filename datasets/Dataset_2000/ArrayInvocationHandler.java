public class ArrayInvocationHandler<Z, D extends Database<Z>, P> extends LocatorInvocationHandler<Z, D, P, Array>
{
	private static final Set<Method> driverReadMethodSet = Methods.findMethods(Array.class, "getBaseType", "getBaseTypeName");
	private static final Set<Method> readMethodSet = Methods.findMethods(Array.class, "getArray", "getResultSet");
	private static final Set<Method> writeMethodSet = Collections.emptySet();
	
	public ArrayInvocationHandler(P parent, SQLProxy<Z, D, P, SQLException> proxy, Invoker<Z, D, P, Array, SQLException> invoker, Map<D, Array> objectMap, boolean updateCopy)
	{
		super(parent, proxy, invoker, Array.class, objectMap, updateCopy, readMethodSet, writeMethodSet);
	}
	
	@Override
	protected InvocationStrategy getInvocationStrategy(Array array, Method method, Object[] parameters) throws SQLException
	{
		if (driverReadMethodSet.contains(method))
		{
			return InvocationStrategyEnum.INVOKE_ON_ANY;
		}
		return super.getInvocationStrategy(array, method, parameters);
	}
	
	@Override
	protected void free(Array array) throws SQLException
	{
		array.free();
	}
}