public final class SetupGauge extends L2GameServerPacket
{
	private static final String _S__85_SETUPGAUGE = "[S] 6b SetupGauge";
	public static final int BLUE = 0;
	public static final int RED = 1;
	public static final int CYAN = 2;
	private int _dat1;
	private int _time;
	private int _time2;
	private int _charObjId;
	public SetupGauge(int dat1, int time)
	{
		_dat1 = dat1;		_time = time;
		_time2 = time;
	}
	public SetupGauge (int color, int currentTime, int maxTime)
	{
		_dat1 = color;		_time = currentTime;
		_time2 = maxTime;
	}
	@Override
	protected final void writeImpl()
	{
		writeC(0x6b);
		writeD(_charObjId);
		writeD(_dat1);
		writeD(_time);
		writeD(_time2);
	}
	@Override
	public String getType()
	{
		return _S__85_SETUPGAUGE;
	}
	@Override
	public void runImpl()
	{
		_charObjId = getClient().getActiveChar().getObjectId();
	}
}