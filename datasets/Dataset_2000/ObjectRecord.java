@java.lang.SuppressWarnings("all")
public class ObjectRecord extends org.jooq.impl.TableRecordImpl<org.jooq.test.hsqldb.generatedclasses.tables.records.ObjectRecord> implements org.jooq.test.hsqldb.generatedclasses.tables.interfaces.IObject {
	private static final long serialVersionUID = 460494204;
	
	@Override
	public void setId(java.lang.Integer value) {
		setValue(org.jooq.test.hsqldb.generatedclasses.tables.Object.OBJECT.ID, value);
	}
	
	@Override
	public java.lang.Integer getId() {
		return getValue(org.jooq.test.hsqldb.generatedclasses.tables.Object.OBJECT.ID);
	}
	
	@Override
	public void setOther(java.lang.Object value) {
		setValue(org.jooq.test.hsqldb.generatedclasses.tables.Object.OBJECT.OTHER, value);
	}
	
	@Override
	public java.lang.Object getOther() {
		return getValue(org.jooq.test.hsqldb.generatedclasses.tables.Object.OBJECT.OTHER);
	}
	
	public ObjectRecord() {
		super(org.jooq.test.hsqldb.generatedclasses.tables.Object.OBJECT);
	}
}