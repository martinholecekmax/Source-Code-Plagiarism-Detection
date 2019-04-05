public class AvroKeyValueInputFormat<K, V> extends FileInputFormat<AvroKey<K>, AvroValue<V>> {
  private static final Logger LOG = LoggerFactory.getLogger(AvroKeyValueInputFormat.class);
  
  @Override
  public RecordReader<AvroKey<K>, AvroValue<V>> createRecordReader(
      InputSplit split, TaskAttemptContext context) throws IOException, InterruptedException {
    Schema keyReaderSchema = AvroJob.getInputKeySchema(context.getConfiguration());
    if (null == keyReaderSchema) {
      LOG.warn("Key reader schema was not set. Use AvroJob.setInputKeySchema() if desired.");
      LOG.info("Using a key reader schema equal to the writer schema.");
    }
    Schema valueReaderSchema = AvroJob.getInputValueSchema(context.getConfiguration());
    if (null == valueReaderSchema) {
      LOG.warn("Value reader schema was not set. Use AvroJob.setInputValueSchema() if desired.");
      LOG.info("Using a value reader schema equal to the writer schema.");
    }
    return new AvroKeyValueRecordReader<K, V>(keyReaderSchema, valueReaderSchema);
  }
}