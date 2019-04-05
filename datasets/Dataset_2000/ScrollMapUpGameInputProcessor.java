public class ScrollMapUpGameInputProcessor extends ScrollMapGameInputProcessor
{
    public ScrollMapUpGameInputProcessor(ScrollMapPlayerGameInput scrollMapPlayerGameInput)
    {
        super(scrollMapPlayerGameInput);
    }
    public void process(AllBinaryLayerManager allbinaryLayerManager, GameKeyEvent gameKeyEvent)
    throws Exception
    {
        this.scrollMapPlayerGameInput.up();
    }
}