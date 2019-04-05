public class BinStorageOutputFormat extends
        FileOutputFormat<org.apache.hadoop.io.WritableComparable, Tuple> {
    
    @Override
    public RecordWriter<WritableComparable, Tuple> getRecordWriter(
            TaskAttemptContext job) throws IOException, InterruptedException {
        Configuration conf = job.getConfiguration();
        Path file = getDefaultWorkFile(job, "");
        FileSystem fs = file.getFileSystem(conf);
        FSDataOutputStream fileOut = fs.create(file, false);
        return new BinStorageRecordWriter(fileOut);
    }
}