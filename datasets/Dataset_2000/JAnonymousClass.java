class JAnonymousClass extends JDefinedClass {
    
    private final JClass base;
    JAnonymousClass( JClass _base) {
        super(_base.owner(), 0, null);
        this.base = _base;
    }
    public String fullName() {
        return base.fullName();
    }
}