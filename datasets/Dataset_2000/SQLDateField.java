class SQLDateField extends SQLField {
    SQLDateField(int sqlDateType, String name) {
        super(sqlDateType, name);
    }
    
    @Override
    public void setValue(Object value) {
        if (value != null && value.getClass() == java.util.Date.class) {
            super.setValue(new java.sql.Timestamp(((java.util.Date)value).getTime()));
        }
        else {
            super.setValue(value);
        }
    }
}