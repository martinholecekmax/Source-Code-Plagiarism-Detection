public final class NodeTokenStream extends TokenStream {
    private final CharTermAttribute termAtt = addAttribute(CharTermAttribute.class);
    private List<Node> nodes;
    private Iterator<Node> iterator;
    private CharSequence nextTokenStringNeedingLeaf = null;
    @Override
    public final boolean incrementToken() throws IOException {
      clearAttributes();
      if (nextTokenStringNeedingLeaf != null) {
        termAtt.append(nextTokenStringNeedingLeaf);
        termAtt.append((char) Node.LEAF_BYTE);
        nextTokenStringNeedingLeaf = null;
        return true;
      }
      if (iterator.hasNext()) {
        Node cell = iterator.next();
        CharSequence token = cell.getTokenString();
        termAtt.append(token);
        if (cell.isLeaf()) {
          nextTokenStringNeedingLeaf = token;
        }
        return true;
      }
      return false;
    }
    @Override
    public void reset() throws IOException {
        iterator = nodes.iterator();
        nextTokenStringNeedingLeaf = null;
    }
    
    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }
}