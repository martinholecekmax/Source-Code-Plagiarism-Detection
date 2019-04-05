public class TableEdgeInputFormat extends
        HBaseVertexInputFormat<Text, Text, Text, Text> {
    private static final Logger log =
            Logger.getLogger(TableEdgeInputFormat.class);
    private static final Text uselessEdgeValue = new Text();
    private Configuration conf;
    public VertexReader<Text, Text, Text, Text>
            createVertexReader(InputSplit split,
                               TaskAttemptContext context) throws IOException {
        return new TableEdgeVertexReader(
                BASE_FORMAT.createRecordReader(split, context));
    }
    
    public static class TableEdgeVertexReader
            extends HBaseVertexReader<Text, Text, Text, Text> {
        private final byte[] CF = Bytes.toBytes("cf");
        private final byte[] CHILDREN = Bytes.toBytes("children");
        public TableEdgeVertexReader(
                RecordReader<ImmutableBytesWritable, Result> recordReader) {
            super(recordReader);
        }
        public boolean nextVertex() throws IOException,
                InterruptedException {
            return getRecordReader().nextKeyValue();
        }
        
        public Vertex<Text, Text, Text, Text>
                    getCurrentVertex()
                throws IOException, InterruptedException {
            Result row = getRecordReader().getCurrentValue();
            Vertex<Text, Text, Text, Text> vertex =
                    BspUtils.<Text, Text, Text, Text>
                            createVertex(getContext().getConfiguration());
            Text vertexId = new Text(Bytes.toString(row.getRow()));
            Map<Text, Text> edges = Maps.newHashMap();
            String edge = Bytes.toString(row.getValue(CF, CHILDREN));
            Text vertexValue = new Text();
            Text edgeId = new Text(edge);
            edges.put(edgeId, uselessEdgeValue);
            vertex.initialize(vertexId, vertexValue, edges);
            return vertex;
        }
    }
}