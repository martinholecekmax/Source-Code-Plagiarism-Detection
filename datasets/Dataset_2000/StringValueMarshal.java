public class StringValueMarshal extends Marshal
{
  public static final Marshal MARSHAL = new StringValueMarshal();
  public boolean isReadOnly()
  {
    return true;
  }
  
  @Override
  public boolean isValue()
  {
    return true;
  }
  @SuppressWarnings("unchecked")
  public <T> T marshal(Env env, Expr expr, Class<T> expectedClass)
  {
    return (T)expr.eval(env).toStringValue(env);
  }
  @SuppressWarnings("unchecked")
  public <T> T marshal(Env env, Value value, Class<T> expectedClass)
  {
    return (T)value.toStringValue(env);
  }
  public Value unmarshal(Env env, Object value)
  {
    if (value instanceof StringValue)
      return (StringValue) value;
    else if (value instanceof Value)
      return ((Value) value).toStringValue(env);
    else if (value != null)
      return env.createStringOld(String.valueOf(value));
    else
      return null;
  }
  @Override
  protected int getMarshalingCostImpl(Value argValue)
  {
    if (argValue.isString()) {
      if (argValue.isUnicode())
        return Marshal.UNICODE_STRING_VALUE_COST;
      else if (argValue.isBinary())
        return Marshal.BINARY_STRING_VALUE_COST;
      else
        return Marshal.PHP5_STRING_VALUE_COST;
    }
    else if (! (argValue.isArray() || argValue.isObject()))
      return Marshal.THREE;
    else
      return Marshal.FOUR;
  }
  public int getMarshalingCost(Expr expr)
  {
    if (expr.isString())
      return Marshal.ZERO;
    else
      return Marshal.FOUR;
  }
  @Override
  public Class getExpectedClass()
  {
    return StringValue.class;
  }
}