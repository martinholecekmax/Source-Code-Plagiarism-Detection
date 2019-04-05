public class NullBindingFactory extends BindingFactoryBase implements IBindingFactory {
    private static final String[] EMPTY_ARRAY = new String[0];
    public NullBindingFactory() {
        super("null", 0, 0, "", "", "", "", EMPTY_ARRAY, EMPTY_ARRAY, "", "",
            EMPTY_ARRAY, "", "", "", "", "", EMPTY_ARRAY);
    }
    public String getCompilerDistribution() {
                return "";
    }
    public int getCompilerVersion() {
                return 0;
    }
    public int getTypeIndex(String type) {
        return -1;
    }
}