public class OperationCadidateEventArgs extends EventArgs {
    private final NetworkOperation candidate;
    private final NetworkItemModel<?> op1;
    private final NetworkItemModel<?> op2;
    public OperationCadidateEventArgs(NetworkOperation candidate, NetworkItemModel<?> op1, NetworkItemModel<?> op2) {
        this.candidate = candidate;
        this.op1 = op1;
        this.op2 = op2;
    }
    public NetworkOperation getCandidate() {
        return candidate;
    }
    public NetworkItemModel<?> getOp1() {
        return op1;
    }
    public NetworkItemModel<?> getOp2() {
        return op2;
    }
}