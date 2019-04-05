public enum DispatchTargets {
    GENERIC("generic"), MAGETAB("magetab"), MEDA("meda"), PRIDEML("prideml"), SRA("sra");
    private String target;
    DispatchTargets(String target) {
        this.target = target;
    }
    @Override
    public String toString() {
        return target;
    }
    public static String[] asStringArray() {
        String[] values = new String[values().length];
        for(int valueIndex = 0; valueIndex < values().length; valueIndex++) {
            values[valueIndex] = values()[valueIndex].toString();
        }
        return values;
    }
}