public class StatusReturnForXmlRpc {
    private static final String STATUS = "status";
        public StatusForXmlRpc mStatus;
    @Override
    public String toString() {
        return ObjectDescriptor.toString(this);
    }
    public StatusReturnForXmlRpc(Map<String, Object> innerMap) {
        Map<String, Object> statusMap = (Map<String, Object>) innerMap.get(STATUS);
        mStatus = new StatusForXmlRpc(statusMap);
    }
}