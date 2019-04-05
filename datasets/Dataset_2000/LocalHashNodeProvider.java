public class LocalHashNodeProvider implements HashNodeProvider{
    private List<HashNode> hashNodes;
    public LocalHashNodeProvider(List<HashNode> hashNodes) {
        this.hashNodes = hashNodes;
    }
    @Override
    public List<Long> getHashNodes(File file, Long[] roots) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}