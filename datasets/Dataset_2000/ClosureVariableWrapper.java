public class ClosureVariableWrapper<T>
{
  private final Class<?> genericTypeParameter;
  private T item;
  
  public ClosureVariableWrapper(T item)
  {
    this.item = item;
    this.genericTypeParameter = SuperTypeToken.getClazz(this.getClass());
  }
  
  public ClosureVariableWrapper(T item, Class<?> genericTypeParameter)
  {
    this.item = item;
    if (genericTypeParameter == null)
      throw new NullPointerException("genericTypeParameter");
    this.genericTypeParameter = genericTypeParameter;
  }
  
  public Class<?> getGenericTypeParameter()
  {
    return genericTypeParameter;
  }
  
  public T get()
  {
    return item;
  }
  
  public void set(T item)
  {
    this.item = item;
  }
}