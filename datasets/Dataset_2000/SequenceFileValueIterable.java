public final class SequenceFileValueIterable<V extends Writable> implements Iterable<V> {
  private final Path path;
  private final boolean reuseKeyValueInstances;
  private final Configuration conf;
  
  public SequenceFileValueIterable(Path path, Configuration conf) {
    this(path, false, conf);
  }
  
  public SequenceFileValueIterable(Path path, boolean reuseKeyValueInstances, Configuration conf) {
    this.path = path;
    this.reuseKeyValueInstances = reuseKeyValueInstances;
    this.conf = conf;
  }
  @Override
  public Iterator<V> iterator() {
    try {
      return new SequenceFileValueIterator<V>(path, reuseKeyValueInstances, conf);
    } catch (IOException ioe) {
      throw new IllegalStateException(path.toString(), ioe);
    }
  }
}