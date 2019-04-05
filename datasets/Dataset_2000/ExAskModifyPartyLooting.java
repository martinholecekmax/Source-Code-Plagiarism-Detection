public class ExAskModifyPartyLooting extends L2GameServerPacket
{
	private static final String _S__FE_BF_EXASKMODIFYPARTYLOOTING = "[S] FE:BF ExAskModifyPartyLooting";
	private final String _requestor;
	private final byte _mode;
	public ExAskModifyPartyLooting(String name, byte mode)
	{
		_requestor = name;
		_mode = mode;
	}
	@Override
	protected void writeImpl()
	{
		writeC(0xFE);
		writeH(0xBF);
		writeS(_requestor);
		writeD(_mode);
	}
	@Override
	public String getType()
	{
		return _S__FE_BF_EXASKMODIFYPARTYLOOTING;
	}
}