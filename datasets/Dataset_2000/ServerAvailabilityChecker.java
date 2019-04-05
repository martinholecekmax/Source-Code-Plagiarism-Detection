public class ServerAvailabilityChecker
{
	protected	String	url;
	protected	ServerAvailabilityListener	listener;
	protected	int		maxFailures;
	protected	int		waitTimeMillis;
	protected	int		numFailures = 0;
	protected	Timer	timer;
	protected	ServerCheckerResponseTextHandler	handler;
	private class ServerCheckerResponseTextHandler implements ResponseTextHandler
	{
		ServerAvailabilityChecker checker;
		public	ServerCheckerResponseTextHandler(ServerAvailabilityChecker checker)
		{
			this.checker = checker;
		}
		public void onCompletion(String responseText)
		{
			if (responseText != null && responseText.length() > 0)
			{
												checker.checkResult(true);
			}
			else
			{
				checker.checkResult(false);
			}
		}
	}
	public	ServerAvailabilityChecker(String url,int maxFailures,
				int waitTimeMillis, ServerAvailabilityListener listener)
	{
		this.url = url;
		this.maxFailures = maxFailures;
		this.listener = listener;
		this.waitTimeMillis = waitTimeMillis;
		this.handler = new  ServerCheckerResponseTextHandler(this);
		timer = new Timer()
		{
			public	void	run()
			{
				runCheck();
			}
		};
	}
	public	void	start()
	{
		this.timer.schedule(this.waitTimeMillis);
	}
	private	void	runCheck()
	{
		if (handler != null)
		{
			try
			{
				if (!HTTPRequest.asyncPost(url+"&cflag="+(getClientGUID()),"a=b",handler))
				{
										checkResult(false);
				}
			}
			catch(Exception e)
			{
								checkResult(false);
			}
		}
	}
	private	void	checkResult(boolean success)
	{
		if (success)
		{
			if (this.listener != null)
			{
				this.listener.serverAvailable();
			}
			else
			{
							}
		}
		else
		{
			this.numFailures++;
			if (this.numFailures >= this.maxFailures)
			{
				if (this.listener != null)
				{
					this.listener.serverUnavailable();
				}
				else
				{
									}
			}
			else
			{
								this.timer.schedule(this.waitTimeMillis);
			}
		}
	}
	private native String getClientGUID() ;
}