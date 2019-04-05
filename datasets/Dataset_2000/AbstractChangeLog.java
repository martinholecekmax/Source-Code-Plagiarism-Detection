public abstract class AbstractChangeLog<T extends Operation> implements ChangeLog {
    
    protected final List<T> operations = new LinkedList<T>();
    
    public void addOperation(T op) throws RepositoryException {
        operations.add(op);
    }
    
    public Batch apply(Batch batch) throws RepositoryException {
        if (batch == null) {
            throw new IllegalArgumentException("Batch must not be null");
        }
        for (Iterator<T> it = operations.iterator(); it.hasNext(); ) {
            Operation op = it.next();
            op.apply(batch);
        }
        return batch;
    }
    @Override
    public String toString() {
        StringBuffer b = new StringBuffer();
        for (Iterator<T> it = operations.iterator(); it.hasNext(); ) {
            b.append(it.next());
            if (it.hasNext()) {
                b.append(", ");
            }
        }
        return b.toString();
    }
    @Override
    public boolean equals(Object other) {
        if (null == other) {
            return false;
        }
        if (this == other) {
            return true;
        }
        if (other instanceof AbstractChangeLog<?>) {
            return equals((AbstractChangeLog<?>) other);
        }
        return false;
    }
    public boolean equals(AbstractChangeLog<?> other) {
        return operations.equals(other.operations);
    }
    @Override
    public int hashCode() {
        throw new IllegalArgumentException("Not hashable");
    }
}