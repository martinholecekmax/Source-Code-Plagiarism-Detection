public class ConcurrentHashMapBeanStore extends AbstractMapBackedBeanStore implements Serializable {
    private static final long serialVersionUID = 4770689245633688471L;
        protected Map<String, Object> delegate;
    private transient volatile LockStore lockStore;
    
    public ConcurrentHashMapBeanStore() {
        delegate = new ConcurrentHashMap<String, Object>();
    }
    
    @Override
    public Map<String, Object> delegate() {
        return delegate;
    }
    @Override
    public String toString() {
        return "contextuals " + delegate;
    }
    public LockedBean lock(final String id) {
        LockStore lockStore = this.lockStore;
        if(lockStore == null) {
            synchronized (this) {
                lockStore = this.lockStore;
                if(lockStore == null) {
                    this.lockStore = lockStore = new LockStore();
                }
            }
        }
        return lockStore.lock(id);
    }
}