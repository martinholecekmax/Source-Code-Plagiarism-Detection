public class MapTableModel extends AbstractTableModel {
    private static final String[] COLUMN_PROPERTIES = new String[]{"Name", "Value"};
    private List<Map.Entry> elements;
    public MapTableModel(List<Map.Entry> elements) {
        this.elements = elements;
    }
    public static MapTableModel createMapTableModel(Map<java.lang.String,java.lang.String> elements){
        Set<Map.Entry<String,String>> entries = elements.entrySet();
        List<Map.Entry> entryList =  Arrays.asList(entries.toArray(new Map.Entry[entries.size()]));
        return new MapTableModel(entryList);
    }
    @Override
    public String getColumnName(int column) {
        return COLUMN_PROPERTIES[column];
    }
    @Override
    public int getRowCount() {
        return elements.size();
    }
    @Override
    public int getColumnCount() {
        return COLUMN_PROPERTIES.length;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Map.Entry entry = elements.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return entry.getKey();
            default:
                return entry.getValue();
        }
    }
}