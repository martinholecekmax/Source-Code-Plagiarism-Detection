public class DefaultOpenFuture extends DefaultSshFuture<OpenFuture> implements OpenFuture {
    public DefaultOpenFuture(Object lock) {
        super(lock);
    }
    public Throwable getException() {
        Object v = getValue();
        if (v instanceof Throwable) {
            return (Throwable) v;
        } else {
            return null;
        }
    }
    public boolean isOpened() {
        return getValue() instanceof Boolean;
    }
    public void setOpened() {
        setValue(Boolean.TRUE);
    }
    public void setException(Throwable exception) {
        if (exception == null) {
            throw new NullPointerException("exception");
        }
        setValue(exception);
    }
}