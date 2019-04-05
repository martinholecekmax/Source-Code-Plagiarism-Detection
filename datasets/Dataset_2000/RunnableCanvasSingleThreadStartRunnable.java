public class RunnableCanvasSingleThreadStartRunnable
extends GameRunnable
{
    private final RunnableCanvas runnableCanvas;
    public RunnableCanvasSingleThreadStartRunnable(RunnableCanvas demoCanvas)
    {
        this.runnableCanvas = demoCanvas;
    }
    public void run()
    {
        try
        {
            runnableCanvas.run();
        }
        catch (Exception e)
        {
            LogUtil.put(LogFactory.getInstance(
                    CommonStrings.getInstance().EXCEPTION,
                    this, CommonStrings.getInstance().RUN, e));
        }
    }
    public void processLoopSleep()
    throws Exception
    {
        runnableCanvas.processLoopSleep();
    }
}