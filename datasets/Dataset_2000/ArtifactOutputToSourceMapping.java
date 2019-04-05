public class ArtifactOutputToSourceMapping extends AbstractStateStorage<String, List<ArtifactOutputToSourceMapping.SourcePathAndRootIndex>> {
  public static DataExternalizer<List<SourcePathAndRootIndex>> EXTERNALIZER = new DataExternalizer<List<SourcePathAndRootIndex>>() {
    private final byte[] myBuffer = IOUtil.allocReadWriteUTFBuffer();
    @Override
    public void save(DataOutput out, List<SourcePathAndRootIndex> value) throws IOException {
      for (SourcePathAndRootIndex pair : value) {
        IOUtil.writeUTFFast(myBuffer, out, pair.myPath);
        out.writeInt(pair.getRootIndex());
      }
    }
    @Override
    public List<SourcePathAndRootIndex> read(DataInput in) throws IOException {
      List<SourcePathAndRootIndex> result = new SmartList<SourcePathAndRootIndex>();
      final DataInputStream stream = (DataInputStream)in;
      while (stream.available() > 0) {
        final String path = IOUtil.readUTFFast(myBuffer, stream);
        final int index = stream.readInt();
        result.add(new SourcePathAndRootIndex(path, index));
      }
      return result;
    }
  };
  public ArtifactOutputToSourceMapping(@NonNls File storePath) throws IOException {
    super(storePath, new PathStringDescriptor(), EXTERNALIZER);
  }
  public static class SourcePathAndRootIndex {
    private final String myPath;
    private final int myRootIndex;
    public SourcePathAndRootIndex(String path, int rootIndex) {
      myPath = path;
      myRootIndex = rootIndex;
    }
    public String getPath() {
      return myPath;
    }
    public int getRootIndex() {
      return myRootIndex;
    }
  }
}