@ServiceProvider(service = DataTableController.class)
public class DataTableControllerImpl implements DataTableController {
    @Override
    public DataTable getDataTable(String name) {
        for (DataTable table : Lookup.getDefault().lookupAll(DataTable.class)) {
            if (table.getName().equals(name)) {
                return table;
            }
        }
        return null;
    }
    @Override
    public GraphDataTable getNodeDataTable() {
        return (GraphDataTable) getDataTable(DataTable.NODES);
    }
    @Override
    public GraphDataTable getEdgeDataTable() {
        return (GraphDataTable) getDataTable(DataTable.EDGES);
    }
    @Override
    public DataNode createDataNode(Tuple data, String labelColumn) {
        DataNodeFactory factory = getDataNodeFactory(data.getTable());
        assert factory != null;
        return factory.createDataNode(data, labelColumn);
    }
    @Override
    public DataNodeFactory getDataNodeFactory(Table table) {
        for (DataNodeFactory factory : Lookup.getDefault().lookupAll(DataNodeFactory.class)) {
            if (factory.readyFor(table)) {
                return factory;
            }
        }
        return null;
    }
    @Override
    public List<DataAction> getDataActionsFor(DataTable table) {
        List<DataAction> actions = new ArrayList<DataAction>();
        for (DataAction a : Lookup.getDefault().lookupAll(DataAction.class)) {
            if (a.isActionFor(table)) {
                actions.add(a);
            }
        }
        return actions;
    }
}