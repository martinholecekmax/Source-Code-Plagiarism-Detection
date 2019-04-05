public final class P117_DialogSenderAction extends GenericAction
{
    private int agentID;
    public short getHeader()
    {
        return 117;
    }
    
    public void setAgentID(int newValue)
    {
        agentID = newValue;
    }
    private int getSize()
    {
        return 6;
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
            buffer.putInt(agentID);
        }
        catch (BufferOverflowException e)
        {
            return false;
        }
        setBuffer(buffer);
        return true;
    }
}