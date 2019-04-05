public final class NullReturn {
    
    public static final NullReturn NULL = new NullReturn();
    
    private NullReturn() {
    }
    
    public String toString() {
        return "null";
    }
}