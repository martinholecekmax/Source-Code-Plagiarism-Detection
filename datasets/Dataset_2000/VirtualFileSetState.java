public class VirtualFileSetState {
  public static final DataExternalizer<VirtualFileSetState> EXTERNALIZER = new VirtualFileWithDependenciesExternalizer();
  private Map<String, Long> myTimestamps = new HashMap<String, Long>();
  public VirtualFileSetState() {
  }
  public VirtualFileSetState(Collection<? extends VirtualFile> files) {
    for (VirtualFile file : files) {
      addFile(file);
    }
  }
  public void addFile(@NotNull VirtualFile file) {
    myTimestamps.put(file.getUrl(), file.getTimeStamp());
  }
  public boolean isUpToDate(Set<? extends VirtualFile> files) {
    if (files.size() != myTimestamps.size()) {
      return false;
    }
    for (VirtualFile file : files) {
      final Long timestamp = myTimestamps.get(file.getUrl());
      if (timestamp == null || timestamp != file.getTimeStamp()) {
        return false;
      }
    }
    return true;
  }
  private static class VirtualFileWithDependenciesExternalizer implements DataExternalizer<VirtualFileSetState> {
    private byte[] myBuffer = IOUtil.allocReadWriteUTFBuffer();
    @Override
    public void save(DataOutput out, VirtualFileSetState value) throws IOException {
      final Map<String, Long> dependencies = value.myTimestamps;
      out.writeInt(dependencies.size());
      for (Map.Entry<String, Long> entry : dependencies.entrySet()) {
        IOUtil.writeUTFFast(myBuffer, out, entry.getKey());
        out.writeLong(entry.getValue());
      }
    }
    @Override
    public VirtualFileSetState read(DataInput in) throws IOException {
      final VirtualFileSetState state = new VirtualFileSetState();
      int size = in.readInt();
      while (size-- > 0) {
        final String url = IOUtil.readUTFFast(myBuffer, in);
        final long timestamp = in.readLong();
        state.myTimestamps.put(url, timestamp);
      }
      return state;
    }
  }
}