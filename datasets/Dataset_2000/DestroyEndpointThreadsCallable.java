public class DestroyEndpointThreadsCallable implements Callable<Boolean>, HazelcastInstanceAware, DataSerializable {
    private transient HazelcastInstance hazelcastInstance;
    private Address endpoint;
    private Set<Integer> threadIds;
    public DestroyEndpointThreadsCallable() {
    }
    public DestroyEndpointThreadsCallable(Address endpoint, Set<Integer> threadIds) {
        this.endpoint = endpoint;
        this.threadIds = threadIds;
    }
    public void addThreadId(int threadId) {
        threadIds.add(threadId);
    }
    public void setHazelcastInstance(HazelcastInstance hazelcastInstance) {
        this.hazelcastInstance = hazelcastInstance;
    }
    public Boolean call() throws Exception {
        final ConcurrentMapManager c = getConcurrentMapManager(hazelcastInstance);
        c.enqueueAndWait(new Processable() {
            public void process() {
                c.destroyEndpointThreads(endpoint, threadIds);
            }
        }, 10);
        return Boolean.TRUE;
    }
    private ConcurrentMapManager getConcurrentMapManager(HazelcastInstance h) {
        FactoryImpl factory = (FactoryImpl) h;
        return factory.node.concurrentMapManager;
    }
    public void writeData(DataOutput out) throws IOException {
        endpoint.writeData(out);
        int size = threadIds.size();
        out.writeInt(size);
        for (Integer threadId : threadIds) {
            out.writeInt(threadId);
        }
    }
    public void readData(DataInput in) throws IOException {
        endpoint = new Address();
        endpoint.readData(in);
        int size = in.readInt();
        threadIds = new HashSet<Integer>(size);
        for (int i = 0; i < size; i++) {
            addThreadId(in.readInt());
        }
    }
}