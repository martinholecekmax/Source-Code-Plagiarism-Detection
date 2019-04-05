abstract class SingleKeyOperationImpl extends OperationImpl implements
    VBucketAware, KeyedOperation {
  protected final String key;
  protected SingleKeyOperationImpl(byte c, int o, String k,
      OperationCallback cb) {
    super(c, o, cb);
    key = k;
  }
  public Collection<String> getKeys() {
    return Collections.singleton(key);
  }
  public Collection<MemcachedNode> getNotMyVbucketNodes() {
    return notMyVbucketNodes;
  }
  public void addNotMyVbucketNode(MemcachedNode node) {
    notMyVbucketNodes.add(node);
  }
  public void setNotMyVbucketNodes(Collection<MemcachedNode> nodes) {
    notMyVbucketNodes = nodes;
  }
  public void setVBucket(String k, short vb) {
    assert k.equals(key) : (k + " doesn't match the key " + key
        + " for this operation");
    vbucket = vb;
  }
  public short getVBucket(String k) {
    assert k.equals(key) : (k + " doesn't match the key " + key
        + " for this operation");
    return vbucket;
  }
  @Override
  public String toString() {
    return super.toString() + " Key: " + key;
  }
}