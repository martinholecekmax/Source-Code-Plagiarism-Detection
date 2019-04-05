public class AmqpValueConstructor extends DescribedTypeConstructor<AmqpValue>
{
    private static final Object[] DESCRIPTORS =
    {
            Symbol.valueOf("amqp:amqp-value:*"),UnsignedLong.valueOf(0x0000000000000077L),
    };
    private static final AmqpValueConstructor INSTANCE = new AmqpValueConstructor();
    public static void register(DescribedTypeConstructorRegistry registry)
    {
        for(Object descriptor : DESCRIPTORS)
        {
            registry.register(descriptor, INSTANCE);
        }
    }
    public AmqpValue construct(Object underlying)
    {
        if(underlying instanceof Object)
        {
            return new AmqpValue((Object)underlying);
        }
        else
        {
                        return null;
        }
    }
}