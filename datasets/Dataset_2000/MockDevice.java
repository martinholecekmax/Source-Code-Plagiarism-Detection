public class MockDevice extends Device {
    public MockDevice(DeviceManagerImpl deviceManager,
                      Long deviceKey,
                      Entity entity, 
                      IEntityClass entityClass)  {
        super(deviceManager, deviceKey, entity, entityClass);
    }
    public MockDevice(Device device, Entity newEntity) {
        super(device, newEntity);
    }
    public MockDevice(DeviceManagerImpl deviceManager, Long deviceKey,
                      List<AttachmentPoint> aps,
                      List<AttachmentPoint> trueAPs,
                      Collection<Entity> entities,
                      IEntityClass entityClass) {
        super(deviceManager, deviceKey, aps, trueAPs, entities, entityClass);
    }
    @Override
    public Integer[] getIPv4Addresses() {
        TreeSet<Integer> vals = new TreeSet<Integer>();
        for (Entity e : entities) {
            if (e.getIpv4Address() == null) continue;
            vals.add(e.getIpv4Address());
        }
        return vals.toArray(new Integer[vals.size()]);
    }
    @Override
    public SwitchPort[] getAttachmentPoints() {
        ArrayList<SwitchPort> vals = 
                new ArrayList<SwitchPort>(entities.length);
        for (Entity e : entities) {
            if (e.getSwitchDPID() != null &&
                e.getSwitchPort() != null &&
                deviceManager.isValidAttachmentPoint(e.getSwitchDPID(), e.getSwitchPort())) {
                SwitchPort sp = new SwitchPort(e.getSwitchDPID(), 
                                               e.getSwitchPort());
                vals.add(sp);
            }
        }
        return vals.toArray(new SwitchPort[vals.size()]);
    }
    @Override
    public String toString() {
        String rv = "MockDevice[entities=+";
        rv += entities.toString();
        rv += "]";
        return rv;
    }
}