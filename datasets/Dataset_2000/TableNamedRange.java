public class TableNamedRange {
    protected String tableBaseCellAddress;
    protected String tableCellRangeAddress;
    protected String tableName;
    protected String tableRangeUsableAs;
    
    public String getTableBaseCellAddress() {
        return this.tableBaseCellAddress;
    }
    
    public String getTableCellRangeAddress() {
        return this.tableCellRangeAddress;
    }
    
    public String getTableName() {
        return this.tableName;
    }
    
    public String getTableRangeUsableAs() {
        if (this.tableRangeUsableAs == null) {
            return "none";
        } else {
            return this.tableRangeUsableAs;
        }
    }
    
    public void setTableBaseCellAddress(final String value) {
        this.tableBaseCellAddress = value;
    }
    
    public void setTableCellRangeAddress(final String value) {
        this.tableCellRangeAddress = value;
    }
    
    public void setTableName(final String value) {
        this.tableName = value;
    }
    
    public void setTableRangeUsableAs(final String value) {
        this.tableRangeUsableAs = value;
    }
}