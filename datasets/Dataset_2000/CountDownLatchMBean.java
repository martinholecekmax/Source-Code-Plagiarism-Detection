@JMXDescription("A distributed CountDownLatch")
public class CountDownLatchMBean extends AbstractMBean<ICountDownLatch> {
    public CountDownLatchMBean(ICountDownLatch managedObject, ManagementService managementService) {
        super(managedObject, managementService);
    }
    @Override
    public ObjectNameSpec getNameSpec() {
        return getParentName().getNested("CountDownLatch", getName());
    }
    @JMXAttribute("Name")
    @JMXDescription("Instance name of the count down latch")
    public String getName() {
        return getManagedObject().getName();
    }
    @JMXAttribute("CurrentCount")
    @JMXDescription("getCount() result")
    public long getCurrentCount() {
        return getCount();
    }
    @JMXAttribute("CurrentOwner")
    @JMXDescription("getOwner() result")
    public Member getCurrentOwner() {
        return getOwner();
    }
    @JMXOperation("countDown")
    @JMXDescription("perform a countdown operation")
    public void countDown() {
        getManagedObject().countDown();
    }
    @JMXOperation("getCount")
    @JMXDescription("return current count value")
    public long getCount() {
        return ((CountDownLatchProxy) getManagedObject()).getCount();
    }
    @JMXOperation("getOwner")
    @JMXDescription("return current count owner")
    public Member getOwner() {
        return ((CountDownLatchProxy) getManagedObject()).getOwner();
    }
}