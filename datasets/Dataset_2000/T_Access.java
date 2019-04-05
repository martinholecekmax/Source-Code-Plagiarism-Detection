public class T_Access
{
	public static AccessFactory getAccessFactory() throws SQLException
	{
		LanguageConnectionContext lcc = ConnectionUtil.getCurrentLCC();
		return lcc.getTransactionExecute().getAccessManager();
	}
	
	public static void waitForPostCommitToFinish() throws SQLException
	{
			AccessFactory af = getAccessFactory();
			af.waitForPostCommitToFinishWork();
	}
}