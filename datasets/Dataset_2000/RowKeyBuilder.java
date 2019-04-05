public class RowKeyBuilder {
	private List<String> columnNames = new ArrayList<String>();
	private Map<String,Object> values;
	private String tableName;
	private Tuple tuple;
	public RowKeyBuilder addColumns(String... columns) {
		for(String columnName : columns ) {
			columnNames.add( columnName );
		}
		return this;
	}
	public RowKeyBuilder values(Map<String,Object> values) {
		this.values = values;
		return this;
	}
	public RowKeyBuilder tableName(String tableName) {
		this.tableName = tableName;
		return this;
	}
	public RowKey build() {
		final String[] columnNamesArray = columnNames.toArray( new String[columnNames.size()] );
		final int length = columnNamesArray.length;
		Object[] columnValuesArray = new Object[length];
		if (values != null) {
			for (int index = 0 ; index < length ; index++ ) {
				columnValuesArray[index] = values.get( columnNamesArray[index] );
			}
		}
		else {
			for (int index = 0 ; index < length ; index++ ) {
				columnValuesArray[index] = tuple.get( columnNamesArray[index] );
			}
		}
		return new RowKey( tableName, columnNamesArray, columnValuesArray );
	}
	public RowKeyBuilder values(Tuple tuple) {
		this.tuple = tuple;
		return this;
	}
	public String[] getColumnNames() {
		return columnNames.toArray( new String[ columnNames.size() ] );
	}
}