public abstract class MCTupleEntryScheme<V> extends MCBaseScheme<TupleEntry, V>
  {
  private String keyDelim = ":";
  private Fields keyFields;
  private Fields valueFields;
  public MCTupleEntryScheme( Fields keyFields, Fields valueFields )
    {
    this( keyFields, valueFields, ":" );
    }
  public MCTupleEntryScheme( Fields keyFields, Fields valueFields, String keyDelim )
    {
    super( Fields.merge( keyFields, valueFields ) );
    this.keyFields = keyFields;
    this.valueFields = valueFields;
    this.keyDelim = keyDelim;
    }
  public String getKeyDelim()
    {
    return keyDelim;
    }
  public Fields getKeyFields()
    {
    return keyFields;
    }
  public Fields getValueFields()
    {
    return valueFields;
    }
  @Override
  protected TupleEntry getIntermediate( TupleEntry tupleEntry )
    {
    return tupleEntry;
    }
  @Override
  protected String getKey( TupleEntry tupleEntry )
    {
    return tupleEntry.selectTuple( getKeyFields() ).toString( getKeyDelim(), false );
    }
  protected abstract V getValue( TupleEntry tupleEntry );
  }