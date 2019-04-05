public abstract class DynamicMeasurement<E extends Type> extends StateAwareMeasurement<E> {
    protected double avg;
    public DynamicMeasurement() {
        setStateAware(true);
    }
    @Override
    public void readExternal(ObjectInput in) throws IOException,
            ClassNotFoundException {
        this.avg = in.readDouble();
    }
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeDouble(avg);
    }
}