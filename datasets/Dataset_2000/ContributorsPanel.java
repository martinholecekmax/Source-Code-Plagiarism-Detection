public class ContributorsPanel extends JPanel {
    
    private JTable table;
    
    private TableModel model;
    
    public ContributorsPanel(final List contributors) {
        setLayout(new BorderLayout());
        this.model = new ContributorsTableModel(contributors);
        this.table = new JTable(this.model);
        add(new JScrollPane(this.table));
    }
}