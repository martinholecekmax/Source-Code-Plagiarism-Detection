public interface StatementReplyInterface {
    public void readPrepareDescribeOutput(StatementCallbackInterface statement) throws DisconnectException;
    public void readExecuteImmediate(StatementCallbackInterface statement) throws DisconnectException;
    public void readOpenQuery(StatementCallbackInterface statement) throws DisconnectException;
    public void readExecute(PreparedStatementCallbackInterface preparedStatement) throws DisconnectException;
    public void readPrepare(StatementCallbackInterface statement) throws DisconnectException;
    public void readDescribeInput(PreparedStatementCallbackInterface preparedStatement) throws DisconnectException;
    public void readDescribeOutput(PreparedStatementCallbackInterface preparedStatement) throws DisconnectException;
    public void readExecuteCall(StatementCallbackInterface statement) throws DisconnectException;
    public void readSetSpecialRegister(StatementCallbackInterface statement) throws DisconnectException;
}