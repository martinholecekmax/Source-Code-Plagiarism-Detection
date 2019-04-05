public final class P431_UnknownAction extends GenericAction
{
    private byte unknown1;
    public short getHeader()
    {
        return 431;
    }
    public void setUnknown1(byte newValue)
    {
        unknown1 = newValue;
    }
    private int getSize()
    {
        return 3;
    }
    @Override
    public boolean serialize()
    {
        int size = getSize();
        if (size == 0)
        {
            return false;
        }
        ByteBuffer buffer = ByteBuffer.allocate(size).order(ByteOrder.LITTLE_ENDIAN);
        try
        {
            buffer.putShort(getHeader());
            buffer.put(unknown1);
        }
        catch (BufferOverflowException e)
        {
            return false;
        }
        setBuffer(buffer);
        return true;
    }
}