public final class PrecisionType extends CodeList<PrecisionType> {
    
    private static final long serialVersionUID = -2771887290382853282L;
    
    private final boolean isFloating;
    
    private static final List<PrecisionType> VALUES = new ArrayList<PrecisionType>(3);
    
    public static final PrecisionType FIXED = new PrecisionType("FIXED", false);
    
    public static final PrecisionType DOUBLE = new PrecisionType("DOUBLE", true);
    
    public static final PrecisionType FLOAT  = new PrecisionType("FLOAT", true);
    
    private PrecisionType(final String name, final boolean isFloating) {
        super(name, VALUES);
        this.isFloating = isFloating;
    }
    
    private PrecisionType(final String name) {
        this(name, true);
    }
    
    public boolean isFloating(){
        return isFloating;
    }
    
    public static PrecisionType[] values() {
        synchronized (VALUES) {
            return VALUES.toArray(new PrecisionType[VALUES.size()]);
        }
    }
    
    public PrecisionType[] family() {
        return values();
    }
    
    public static PrecisionType valueOf(String code) {
        return valueOf(PrecisionType.class, code);
    }
}