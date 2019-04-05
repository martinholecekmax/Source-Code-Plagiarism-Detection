public class ProjectStateInternal implements ProjectState {
    private boolean executing;
    private boolean executed;
    private Throwable failure;
    public boolean getExecuted() {
        return executed;
    }
    public void executed() {
        executed = true;
    }
    public void executed(Throwable failure) {
        assert this.failure == null;
        this.failure = failure;
        executed = true;
    }
    public boolean getExecuting() {
        return executing;
    }
    public void setExecuting(boolean executing) {
        this.executing = executing;
    }
    public Throwable getFailure() {
        return failure;
    }
    public void rethrowFailure() {
        if (failure == null) {
            return;
        }
        throw UncheckedException.throwAsUncheckedException(failure);
    }
    public String toString() {
        String state;
        if (getExecuting()) {
            state = "EXECUTING";
        } else if (getExecuted()) {
            if (failure == null) {
                state = "EXECUTED";
            } else {
                state = String.format("FAILED (%s)", failure.getMessage());
            }
        } else {
            state = "NOT EXECUTED";
        }
        return String.format("project state '%s'", state);
    }
}