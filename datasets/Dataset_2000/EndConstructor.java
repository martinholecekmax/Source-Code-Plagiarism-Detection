public class EndConstructor extends DescribedTypeConstructor<End>
{
    private static final Object[] DESCRIPTORS =
    {
            Symbol.valueOf("amqp:end:list"),UnsignedLong.valueOf(0x0000000000000017L),
    };
    private static final EndConstructor INSTANCE = new EndConstructor();
    public static void register(DescribedTypeConstructorRegistry registry)
    {
        for(Object descriptor : DESCRIPTORS)
        {
            registry.register(descriptor, INSTANCE);
        }
    }
    public End construct(Object underlying)
    {
        if(underlying instanceof List)
        {
            List list = (List) underlying;
            End obj = new End();
            int position = 0;
            final int size = list.size();
            if(position < size)
            {
                Object val = list.get(position);
                position++;
                if(val != null)
                {
                    try
                    {
                        obj.setError( (org.apache.qpid.amqp_1_0.type.transport.Error) val );
                    }
                    catch(ClassCastException e)
                    {
                                            }
                }
            }
            else
            {
                return obj;
            }
            return obj;
        }
        else
        {
                        return null;
        }
    }
}