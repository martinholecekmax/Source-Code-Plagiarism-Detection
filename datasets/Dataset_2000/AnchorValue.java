public class AnchorValue extends StyledValue {
    private final String[] names;
    public AnchorValue(String... names) {
        super(join(names, ", "));
        this.names = defaultIfNull(names, EMPTY_STRING_ARRAY);
    }
    public String[] getNames() {
        return names;
    }
}