public interface Proposer {
    public enum ProposerState {
        INACTIVE, PREPARING, PREPARED
    }
    public void start();
    public ProposerState getState();
    public void ballotFinished();
    public void stopProposer();
    public void onPrepareOK(PrepareOK msg, int sender);
    public void propose(Request[] requests, byte[] value);
    public void prepareNextView();
    
    public void stopPropose(int instanceId);
    
    public void stopPropose(int instanceId, int destination);
}