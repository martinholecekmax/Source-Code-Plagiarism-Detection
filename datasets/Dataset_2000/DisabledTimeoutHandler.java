public class DisabledTimeoutHandler implements TimeoutHandler{
    
    public boolean hasTimedOut(Map<String,Object> args) {
                return false;
    }
    
    public int getTimeout(Map<String,Object> args) {
        return 0;
    }
}