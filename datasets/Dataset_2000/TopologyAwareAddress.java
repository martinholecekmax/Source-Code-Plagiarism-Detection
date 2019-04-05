public interface TopologyAwareAddress extends Address {
   String getSiteId();
   String getRackId();
   String getMachineId();
   boolean isSameSite(TopologyAwareAddress addr);
   boolean isSameRack(TopologyAwareAddress addr);
   boolean isSameMachine(TopologyAwareAddress addr);
}