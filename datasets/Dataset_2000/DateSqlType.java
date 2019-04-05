public class DateSqlType implements SQLType<Date> {
    
    public void bindParam(PreparedStatement ps, int parameterIndex, Date value) throws SQLException {
        ps.setTimestamp(parameterIndex, new java.sql.Timestamp(value.getTime()));
    }
    
    public String getValueAsString(Date value) {
        return String.valueOf(value.getTime());
    }
    
    public String formatValue(Date value) {
        return "to_timestamp(\'" + value.toString() + "\', " + EventConstants.POSTGRES_DATE_FORMAT +")";
    }
    
    public Date[] createArray(Date value1, Date value2) {
        return new Date[] { value1, value2 };
    }
}