public class LongDoubleValueLoader extends PQValueLoader {
	@Override
	public BaseKeyValue<Long,Double> getPOJOProperty(LogElement e) 
	{
		return new TemplateProperty<Long, Double>(e);
	}
	@Override
	public Class getPOJOClass() {
		return TemplateProperty.class;
	}
}