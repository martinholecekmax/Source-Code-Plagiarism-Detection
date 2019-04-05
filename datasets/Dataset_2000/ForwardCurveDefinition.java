public abstract class ForwardCurveDefinition {
  private final String _name;
  private final UniqueIdentifiable _target;
  private final Tenor[] _tenors;
  public ForwardCurveDefinition(final String name, final UniqueIdentifiable target, final Tenor[] tenors) {
    ArgumentChecker.notNull(name, "name");
    ArgumentChecker.notNull(target, "target");
    ArgumentChecker.notNull(tenors, "xs");
    _name = name;
    _target = target;
    _tenors = tenors;
  }
  public Tenor[] getTenors() {
    return _tenors;
  }
  public String getName() {
    return _name;
  }
  public UniqueIdentifiable getTarget() {
    return _target;
  }
  @Override
  public int hashCode() {
    return getTarget().hashCode() * getTarget().hashCode();
  }
  @Override
  public boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof ForwardCurveDefinition)) {
      return false;
    }
    final ForwardCurveDefinition other = (ForwardCurveDefinition) obj;
    return getTarget().equals(other.getTarget()) &&
        getName().equals(other.getName()) &&
        Arrays.equals(getTenors(), other.getTenors());
  }
  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }
}