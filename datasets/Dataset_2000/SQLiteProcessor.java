public class SQLiteProcessor
        extends DefaultSQLProcessor
{
    private static final Map<Class<? extends Typeable<?>>, SQLProcessor> _defaultProcessors;
    static {
        Map<Class<? extends Typeable<?>>, SQLProcessor> processors = new HashMap<Class<? extends Typeable<?>>, SQLProcessor>(
                DefaultSQLProcessor.getDefaultProcessors() );
                processors.put( TableNameDirect.class, new TableProcessing.MySQLTableNameDirectProcessor() );
        processors.put( TableNameFunction.class, new TableProcessing.MySQLTableNameFunctionProcessor() );
                processors.put( SchemaDefinition.class, new SQLiteSchemaDefinitionProcessor() );
        processors.put( DropSchemaStatement.class, new NoOpProcessor() );
                                processors.put( TableElementList.class, new SQLListeTableElementListProcessor() );
                Map<Class<?>, String> autoGenDataTypes = new HashMap<Class<?>, String>();
        autoGenDataTypes.put( BigInt.class, "INTEGER PRIMARY KEY AUTOINCREMENT" );
        autoGenDataTypes.put( SQLInteger.class, "INTEGER PRIMARY KEY AUTOINCREMENT" );
        autoGenDataTypes.put( SmallInt.class, "INTEGER PRIMARY KEY AUTOINCREMENT" );
        processors.put( ColumnDefinition.class, new SQLiteColumnDefinitionProcessor( autoGenDataTypes ) );
        _defaultProcessors = processors;
    }
    public SQLiteProcessor( SQLVendor vendor )
    {
        super( vendor, _defaultProcessors );
    }
}