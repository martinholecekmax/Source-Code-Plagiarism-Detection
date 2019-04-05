public class InstanceCreatedHandler implements ChangeEventHandler {
    final private ClusterWidgets clusterWidgets;
    public InstanceCreatedHandler(ClusterWidgets clusterWidgets) {
        this.clusterWidgets = clusterWidgets;
    }
    public void handle(ChangeEvent e) {
        InstanceCreated event = (InstanceCreated) e;
        InstanceWidgets instanceWidgets = clusterWidgets.getItemMap().get(event.getInstanceType());
        String name = event.getName();
        Widget link = clusterWidgets.getInstanceLink(event.getInstanceType(), event.getName());
        instanceWidgets.getTreeItem().addItem(link);
    }
}