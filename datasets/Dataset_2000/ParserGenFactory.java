public class ParserGenFactory extends PipeFactory
  {
  public ParserGenFactory( String alias )
    {
    super( alias );
    }
  public String getUsage()
    {
    return "parse the first field with given regex, return as new tuples";
    }
  public String[] getParameters()
    {
    return new String[]{};
    }
  public String[] getParametersUsage()
    {
    return new String[]{};
    }
  public Pipe addAssembly( String value, Map<String, String> subParams, Map<String, Pipe> pipes, Pipe pipe )
    {
    return new Each( pipe, Fields.FIRST, new RegexGenerator( value ) );
    }
  }