public abstract class BaseEvaluator
    implements
    Evaluator, Externalizable {
    private Operator  operator;
    private ValueType type;
    public BaseEvaluator() {
    }
    public BaseEvaluator(final ValueType type,
                         final Operator operator) {
        this.type = type;
        this.operator = operator;
    }
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        operator    = (Operator)in.readObject();
        type        = (ValueType)in.readObject();
        if (type != null)
            type   = ValueType.determineValueType(type.getClassType());
    }
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(operator);
        out.writeObject(type);
    }
    public Operator getOperator() {
        return this.operator;
    }
    public ValueType getValueType() {
        return this.type;
    }
    public ValueType getCoercedValueType() {
        return this.type;
    }
    public Object prepareObject(InternalFactHandle handle) {
        return handle.getObject();
    }
    public boolean isTemporal() {
        return false;
    }
    public Interval getInterval() {
                return new Interval();
    }
    public boolean equals(final Object object) {
        if ( this == object ) {
            return true;
        }
        if ( object == null || !(object instanceof BaseEvaluator) ) {
            return false;
        }
        final Evaluator other = (Evaluator) object;
        return this.getOperator() == other.getOperator() && this.getValueType() == other.getValueType();
    }
    public int hashCode() {
        return (this.getValueType().hashCode()) ^ (this.getOperator().hashCode()) ^ (this.getClass().hashCode());
    }
}