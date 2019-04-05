public class KeyLocker<K> {
  private static final Log LOG = LogFactory.getLog(KeyLocker.class);
    private static final int NB_CONCURRENT_LOCKS = 1000;
      private final Map<K, Pair<KeyLock<K>, AtomicInteger>> locks =
    new HashMap<K, Pair<KeyLock<K>, AtomicInteger>>(NB_CONCURRENT_LOCKS);
  
  public ReentrantLock acquireLock(K key) {
    if (key == null) throw new IllegalArgumentException("key must not be null");
    Pair<KeyLock<K>, AtomicInteger> lock;
    synchronized (this) {
      lock = locks.get(key);
      if (lock == null) {
        lock = new Pair<KeyLock<K>, AtomicInteger>(
          new KeyLock<K>(this, key), new AtomicInteger(1));
        locks.put(key, lock);
      } else {
        lock.getSecond().incrementAndGet();
      }
    }
    lock.getFirst().lock();
    return lock.getFirst();
  }
  
  private synchronized void releaseLock(K key) {
    Pair<KeyLock<K>, AtomicInteger> lock = locks.get(key);
    if (lock != null) {
      if (lock.getSecond().decrementAndGet() == 0) {
        locks.remove(key);
      }
    } else {
      String message = "Can't release the lock for " + key+", this key is not in the key list." +
        " known keys are: "+ locks.keySet();
      LOG.error(message);
      throw new RuntimeException(message);
    }
  }
  static class KeyLock<K> extends ReentrantLock {
    private final KeyLocker<K> locker;
    private final K lockId;
    private KeyLock(KeyLocker<K> locker, K lockId) {
      super();
      this.locker = locker;
      this.lockId = lockId;
    }
    @Override
    public void unlock() {
      super.unlock();
      locker.releaseLock(lockId);
    }
  }
}