public class AnagramReducer extends MapReduceBase implements Reducer<Text, Text, Text, Text>
{
            @Override
  public void reduce(Text key, Iterator<Text> values, OutputCollector<Text, Text> output, Reporter reporter)
      throws IOException
  {
    String newKey = "";
    String newValue = "";
    while (values.hasNext())
    {
      if (newKey.length() == 0)
      {
        newKey = values.next().toString();
      }
      else
      {
        newValue += ", " + values.next().toString();
      }
    }
    if (newValue.length() > 0)
    {
      newValue = newValue.substring(2);
      output.collect(new Text(newKey), new Text(newValue));
    }
  }
}