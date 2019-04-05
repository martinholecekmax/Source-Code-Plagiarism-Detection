public class TupleFieldSerialization implements Serialization<ITuple>, FieldConfigurable, Configurable {
	private Schema schema;
	private HadoopSerialization ser;
	private Configuration conf;
	@Override
  public void setFieldProperties(Map<String, String> props) {
		schema = Schema.parse(props.get("schema"));
  }
	@Override
  public boolean accept(Class<?> argClazz) {
	  return true;   }
	@Override
  public Deserializer<ITuple> getDeserializer(Class<ITuple> argClazz) {
	  return new SimpleTupleDeserializer(schema, ser, conf);
  }
	@Override
  public Serializer<ITuple> getSerializer(Class<ITuple> argClazz) {
	  return new SimpleTupleSerializer(schema, ser, conf);
  }
	@Override
  public Configuration getConf() {
	  return conf;
  }
	@Override
  public void setConf(Configuration conf) {
		this.conf = conf;
		try {
	    this.ser = new HadoopSerialization(conf);
    } catch(IOException e) {
	    throw new RuntimeException(e);
    }
  }
}