public enum ISFILENAMEFIELDType implements Enumerator {
    
    YES(0, "YES", "YES"),
    
    NO(1, "NO", "NO");
    
    public static final int YES_VALUE = 0;
    
    public static final int NO_VALUE = 1;
    
    private static final ISFILENAMEFIELDType[] VALUES_ARRAY =
        new ISFILENAMEFIELDType[] {
            YES,
            NO,
        };
    
    public static final List<ISFILENAMEFIELDType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));
    
    public static ISFILENAMEFIELDType get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            ISFILENAMEFIELDType result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }
    
    public static ISFILENAMEFIELDType getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            ISFILENAMEFIELDType result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }
    
    public static ISFILENAMEFIELDType get(int value) {
        switch (value) {
            case YES_VALUE: return YES;
            case NO_VALUE: return NO;
        }
        return null;
    }
    
    private final int value;
    
    private final String name;
    
    private final String literal;
    
    private ISFILENAMEFIELDType(int value, String name, String literal) {
        this.value = value;
        this.name = name;
        this.literal = literal;
    }
    
    public int getValue() {
      return value;
    }
    
    public String getName() {
      return name;
    }
    
    public String getLiteral() {
      return literal;
    }
    
    @Override
    public String toString() {
        return literal;
    }
}