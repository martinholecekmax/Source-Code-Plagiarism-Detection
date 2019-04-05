public class HpnameToken implements GameModeLstToken
{
	public String getTokenName()
	{
		return "HPNAME";
	}
	public boolean parse(GameMode gameMode, String value, URI source)
	{
		gameMode.setHPText(value);
		return true;
	}
}