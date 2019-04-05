public class GetConversationCountTask implements ClusterTask {
    private int conversationCount;
    public Object getResult() {
        return conversationCount;
    }
    public void run() {
        MonitoringPlugin plugin = (MonitoringPlugin) XMPPServer.getInstance().getPluginManager().getPlugin(
            "monitoring");
        ConversationManager conversationManager = (ConversationManager)plugin.getModule(ConversationManager.class);
        conversationCount = conversationManager.getConversationCount();
    }
    public void writeExternal(ObjectOutput out) throws IOException {
            }
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            }
}