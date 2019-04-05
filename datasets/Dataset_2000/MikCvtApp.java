public class MikCvtApp extends Applet implements Runnable
{
	Thread	 m_MikCvtApp = null;
	boolean m_fStandAlone = false;
        public static String [] my_argv = null;
                public static void main(String args[])
	{
		MikCvtApp applet_MikCvtApp = new MikCvtApp();
		applet_MikCvtApp.m_fStandAlone = true;
                {
                    my_argv = new String[args.length+1];
                    my_argv[0] = new String("mikcvt");
                    int i;
                    for(i=0;i<args.length;i++)
                    {
                        my_argv[i+1] = new String(args[i]);
                    }
                }
		applet_MikCvtApp.init();
		applet_MikCvtApp.start();
	}
	public MikCvtApp()
	{
	}
        	public String getAppletInfo()
	{
            return "Name: MikCvtApp: Java version of MikMod's mikcvt utility\r\n" +
                "Original Code: Jean-Paul Mikkers and others\r\n" +
                "Java Porting: Shlomi Fish";
	}
        	public void init()
	{
	}
	public void destroy()
        {
	}
                public void paint(Graphics g)
	{
	}
	public void start()
	{
		if (m_MikCvtApp == null)
		{
			m_MikCvtApp = new Thread(this);
			m_MikCvtApp.start();
		}
	}
	public void stop()
	{
		if (m_MikCvtApp != null)
		{
			m_MikCvtApp.stop();
			m_MikCvtApp = null;
		}
	}
	public void run()
	{
            clMikCvtMain mikCvt = new clMikCvtMain();
            mikCvt.main(my_argv);
            stop();
	}
}