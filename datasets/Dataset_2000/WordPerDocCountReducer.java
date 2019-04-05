public class WordPerDocCountReducer extends Reducer<Text, StringListIntListWritable, TextArrayWritable, StringListIntListWritable> {
    private static Logger logger = Logger.getLogger(LoggingInDisambiguation.class);
        @Override
    public void setup(Context context) throws IOException, InterruptedException {
        logger.setLevel(Level.DEBUG);
    }
    @Override
    
    public void reduce(Text key, Iterable<StringListIntListWritable> values, Context context) {
        int dwc = 0;
        for (StringListIntListWritable slilw : values) {
            dwc += slilw.getIntList().get(0);
        }
        for (StringListIntListWritable slilw : values) {
            StringListIntListWritable out_slilw = new StringListIntListWritable();
            out_slilw.addInt(slilw.getIntList().get(0));
            out_slilw.addInt(dwc);
            try {
                context.write(
                        new TextArrayWritable(new Text[]{key,
                            new Text(slilw.getStringList().get(0))}),
                        out_slilw);
            } catch (IOException e) {
                                e.printStackTrace();
            } catch (InterruptedException e) {
                                e.printStackTrace();
            }
        }
    }
}