public class AmqpValueWriter extends AbstractDescribedTypeWriter<AmqpValue>
{
    private AmqpValue _value;
    public AmqpValueWriter(final Registry registry)
    {
        super(registry);
    }
    @Override
    protected void onSetValue(final AmqpValue value)
    {
        _value = value;
    }
    @Override
    protected void clear()
    {
        _value = null;
    }
    protected Object getDescriptor()
    {
        return UnsignedLong.valueOf(0x0000000000000077L);
    }
    @Override
    protected ValueWriter createDescribedWriter()
    {
        return getRegistry().getValueWriter(_value.getValue());
    }
    private static Factory<AmqpValue> FACTORY = new Factory<AmqpValue>()
    {
        public ValueWriter<AmqpValue> newInstance(Registry registry)
        {
            return new AmqpValueWriter(registry);
        }
    };
    public static void register(ValueWriter.Registry registry)
    {
        registry.register(AmqpValue.class, FACTORY);
    }
}