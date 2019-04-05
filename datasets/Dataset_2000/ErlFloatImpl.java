public class ErlFloatImpl extends ExpressionImpl implements ErlFloat
{
  
  protected static final String VALUE_EDEFAULT = null;
  
  protected String value = VALUE_EDEFAULT;
  
  protected ErlFloatImpl()
  {
    super();
  }
  
  @Override
  protected EClass eStaticClass()
  {
    return ErlangPackage.Literals.ERL_FLOAT;
  }
  
  public String getValue()
  {
    return value;
  }
  
  public void setValue(String newValue)
  {
    String oldValue = value;
    value = newValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErlangPackage.ERL_FLOAT__VALUE, oldValue, value));
  }
  
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ErlangPackage.ERL_FLOAT__VALUE:
        return getValue();
    }
    return super.eGet(featureID, resolve, coreType);
  }
  
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ErlangPackage.ERL_FLOAT__VALUE:
        setValue((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }
  
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case ErlangPackage.ERL_FLOAT__VALUE:
        setValue(VALUE_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }
  
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case ErlangPackage.ERL_FLOAT__VALUE:
        return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
    }
    return super.eIsSet(featureID);
  }
  
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();
    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (value: ");
    result.append(value);
    result.append(')');
    return result.toString();
  }
}