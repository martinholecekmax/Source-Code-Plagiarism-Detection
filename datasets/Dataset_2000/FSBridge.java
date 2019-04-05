public class FSBridge extends AbstractFSBridge {
    public static final FSBridge _ = new FSBridge();
    private FSBridge(){}
    @Override
    protected void loadFile(File file) throws IOException {
        __(new AnimoExpression(new FileInputStream(file)));
    }
}