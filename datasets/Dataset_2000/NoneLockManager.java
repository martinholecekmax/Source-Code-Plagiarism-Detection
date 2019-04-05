public class NoneLockManager
    extends AbstractLockManager {
    public void lock(OpenJPAStateManager sm, int level, int timeout,
        Object context) {
                        sm.setLock(Boolean.TRUE);
    }
    public void refreshLock(OpenJPAStateManager sm, int level, int timeout,
        Object context) {
        sm.setLock(Boolean.TRUE);
    }
    public void release(OpenJPAStateManager sm) {
        sm.setLock(null);
    }
    public int getLockLevel(OpenJPAStateManager sm) {
        return LOCK_NONE;
    }
}