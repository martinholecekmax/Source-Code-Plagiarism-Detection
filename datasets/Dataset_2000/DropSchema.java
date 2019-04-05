public class DropSchema extends DefineCommand {
    private String schemaName;
    private boolean ifExists;
    public DropSchema(Session session) {
        super(session);
    }
    public void setSchemaName(String name) {
        this.schemaName = name;
    }
    public int update() {
        session.getUser().checkAdmin();
        session.commit(true);
        Database db = session.getDatabase();
        Schema schema = db.findSchema(schemaName);
        if (schema == null) {
            if (!ifExists) {
                throw DbException.get(ErrorCode.SCHEMA_NOT_FOUND_1, schemaName);
            }
        } else {
            if (!schema.canDrop()) {
                throw DbException.get(ErrorCode.SCHEMA_CAN_NOT_BE_DROPPED_1, schemaName);
            }
            db.removeDatabaseObject(session, schema);
        }
        return 0;
    }
    public void setIfExists(boolean ifExists) {
        this.ifExists = ifExists;
    }
}