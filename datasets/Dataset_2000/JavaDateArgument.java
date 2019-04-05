class JavaDateArgument implements Argument
{
    private final Date value;
    JavaDateArgument(Date value)
    {
        this.value = value;
    }
    public void apply(int position, PreparedStatement statement, StatementContext ctx) throws SQLException
    {
        if (value != null) {
            statement.setTimestamp(position, new Timestamp(value.getTime()));
        }
        else {
            statement.setNull(position, Types.TIMESTAMP);
        }
    }
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}