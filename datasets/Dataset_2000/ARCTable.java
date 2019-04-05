public class ARCTable extends javax.swing.JPanel {
    private RowHeaderTable rowHeader;
    private MyJTable table;
    
    public ARCTable() {
        initComponents();
        table = new MyJTable();
        tableScrollPane.setViewportView(table);
    }
    public void setModel(MyDefaultTableModel model) {
        table.setModel(model);
        initRowHeader();
    }
    
    @SuppressWarnings("unchecked")
        private void initComponents() {
        tableScrollPane = new javax.swing.JScrollPane();
        setMinimumSize(new java.awt.Dimension(25, 500));
        setLayout(new java.awt.GridLayout(1, 1));
        add(tableScrollPane);
    }    public void resizeColumn() {
        table.resizeColumn();
    }
    protected void initRowHeader() {
        rowHeader = new RowHeaderTable(table);
        tableScrollPane.setRowHeaderView(rowHeader);
        JTableHeader corner = rowHeader.getTableHeader();
        tableScrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, corner);
        new JScrollPaneAdjuster(tableScrollPane);
        new JTableRowHeaderResizer(tableScrollPane).setEnabled(false);
    }
        private javax.swing.JScrollPane tableScrollPane;
    }