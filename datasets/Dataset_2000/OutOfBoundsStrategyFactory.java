public abstract class OutOfBoundsStrategyFactory<T extends Type<T>> implements Factory
{
	public abstract OutOfBoundsStrategy<T> createStrategy( LocalizableCursor<T> cursor ); 
	@Override
	public String getErrorMessage()
	{
				return null;
	}
	@Override
	public void printProperties()
	{
			}
	@Override
	public void setParameters(String configuration)
	{
			}
}