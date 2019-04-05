public class ConnectionReply {
    private ConnectionReplyInterface materialConnectionReply_;
    org.apache.derby.client.am.Agent agent_;
    ConnectionReply(org.apache.derby.client.am.Agent agent, ConnectionReplyInterface materialConnectionReply) {
        agent_ = agent;
        materialConnectionReply_ = materialConnectionReply;
    }
    public void readCommitSubstitute(ConnectionCallbackInterface connection) throws SqlException {
        materialConnectionReply_.readCommitSubstitute(connection);
        agent_.checkForChainBreakingException_();
    }
    public void readLocalCommit(ConnectionCallbackInterface connection) throws SqlException {
        materialConnectionReply_.readLocalCommit(connection);
        agent_.checkForChainBreakingException_();
    }
    public void readLocalRollback(ConnectionCallbackInterface connection) throws SqlException {
        materialConnectionReply_.readLocalRollback(connection);
        agent_.checkForChainBreakingException_();
    }
    public void readLocalXAStart(ConnectionCallbackInterface connection) throws SqlException {
        materialConnectionReply_.readLocalXAStart(connection);
        agent_.checkForChainBreakingException_();
    }
    public void readLocalXACommit(ConnectionCallbackInterface connection) throws SqlException {
        materialConnectionReply_.readLocalXACommit(connection);
        agent_.checkForChainBreakingException_();
    }
    public void readLocalXARollback(ConnectionCallbackInterface connection) throws SqlException {
        materialConnectionReply_.readLocalXARollback(connection);
        agent_.checkForChainBreakingException_();
    }
}