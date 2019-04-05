public class SuccessfullAnnounceFrame extends AnnounceFrame
{
    private static final int DEFAULT_LIVETIME = 10;
    
    public SuccessfullAnnounceFrame(String message, int liveTime)
    {
        super(message, liveTime);
        ThreadUtil.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                mainPanel.setOpaque(true);
                mainPanel.setBackground(new Color(128, 255, 128));
            }
        });
    }
    
    public SuccessfullAnnounceFrame(String message)
    {
        this(message, DEFAULT_LIVETIME);
    }
}