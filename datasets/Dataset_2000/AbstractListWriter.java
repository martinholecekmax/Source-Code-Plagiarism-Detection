public abstract class AbstractListWriter<V> extends CompoundWriter<V>
{
    public AbstractListWriter(final Registry registry)
    {
        super(registry);
    }
    @Override
    protected byte getFourOctetEncodingCode()
    {
        return (byte)0xd0;
    }
    @Override
    protected byte getSingleOctetEncodingCode()
    {
        return (byte)0xc0;
    }
}