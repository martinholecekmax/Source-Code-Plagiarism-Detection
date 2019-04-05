public class SuppliersPanel extends JPanelTable {
    private TableDefinition tsuppliers;
    private SuppliersView jeditor;
    
    public SuppliersPanel() {    
    }
    protected void init() {        
        DataLogicSuppliers dlSuppliers  = (DataLogicSuppliers) app.getBean("com.openbravo.pos.suppliers.DataLogicSuppliers");
        tsuppliers = dlSuppliers.getTableSuppliers();
        jeditor = new SuppliersView(app, dirty);
    }
    @Override
    public void activate() throws BasicException { 
        jeditor.activate();         
        super.activate();
    }
    public ListProvider getListProvider() {
        return new ListProviderCreator(tsuppliers);
    }
    public SaveProvider getSaveProvider() {
        return new SaveProvider(tsuppliers, new int[] {0, 1, 2, 3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22});
    }
    @Override
    public Vectorer getVectorer() {
        return tsuppliers.getVectorerBasic(new int[]{1, 2, 3, 4});
    }
    @Override
    public ComparatorCreator getComparatorCreator() {
        return tsuppliers.getComparatorCreator(new int[] {1, 2, 3, 4});
    }
    @Override
    public ListCellRenderer getListCellRenderer() {
        return new ListCellRendererBasic(tsuppliers.getRenderStringBasic(new int[]{3}));
    }
    public EditorRecord getEditor() {
        return jeditor;
    }       
    public String getTitle() {
        return AppLocal.getIntString("Menu.SuppliersManagement");
    }    
}