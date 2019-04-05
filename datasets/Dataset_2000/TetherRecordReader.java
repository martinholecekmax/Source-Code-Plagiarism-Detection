class TetherRecordReader
  implements RecordReader<TetherData, NullWritable> {
  private FsInput in;
  private DataFileReader reader;
  private long start;
  private long end;
  public TetherRecordReader(JobConf job, FileSplit split)
    throws IOException {
    this.in = new FsInput(split.getPath(), job);
    this.reader =
      new DataFileReader<Object>(in, new GenericDatumReader<Object>());
    reader.sync(split.getStart());                        this.start = in.tell();
    this.end = split.getStart() + split.getLength();
    job.set(AvroJob.INPUT_SCHEMA, reader.getSchema().toString());
  }
  public Schema getSchema() { return reader.getSchema(); }
  public TetherData createKey() { return new TetherData(); }
  public NullWritable createValue() { return NullWritable.get(); }
  public boolean next(TetherData data, NullWritable ignore)
    throws IOException {
    if (!reader.hasNext() || reader.pastSync(end))
      return false;
    data.buffer(reader.nextBlock());
    data.count((int)reader.getBlockCount());
    return true;
  }
  public float getProgress() throws IOException {
    if (end == start) {
      return 0.0f;
    } else {
      return Math.min(1.0f, (in.tell() - start) / (float)(end - start));
    }
  }
  public long getPos() throws IOException {
    return in.tell();
  }
  public void close() throws IOException { reader.close(); }
}