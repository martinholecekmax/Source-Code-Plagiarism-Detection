public class ShortWriter extends FixedTwoWriter<Short>
{
    private static final byte FORMAT_CODE = (byte)0x61;
    @Override
    short convertValueToShort(Short value)
    {
        return value.shortValue();
    }
    @Override
    byte getFormatCode()
    {
        return FORMAT_CODE;
    }
    private static Factory<Short> FACTORY = new Factory<Short>()
                                            {
                                                public ValueWriter<Short> newInstance(Registry registry)
                                                {
                                                    return new ShortWriter();
                                                }
                                            };
    public static void register(ValueWriter.Registry registry)
    {
        registry.register(Short.class, FACTORY);
    }
}