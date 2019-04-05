public class StartIntermissionPaintable extends InitUpdatePaintable
{
    protected AllBinaryGameCanvas gameCanvas;
    protected String[] stringArray;
    protected final BasicColorSetUtil basicColorUtil = 
        BasicColorSetUtil.getInstance();
    private BasicColor basicColor;
    private int color;
    private final int[] lineArray;
    public StartIntermissionPaintable(AllBinaryGameCanvas gameCanvas, String[] stringArray, int[] lineArray, BasicColor basicColor)
    {
        this.gameCanvas = gameCanvas;
        this.stringArray = stringArray;
        this.setBasicColor(basicColor);
        this.color = basicColor.intValue();
        this.lineArray = lineArray;
    }
    private int anchor = Anchor.TOP_LEFT;
    public void paint(Graphics graphics)
    {
                DisplayInfoSingleton displayInfo = DisplayInfoSingleton.getInstance();
        basicColorUtil.setBasicColor(graphics, this.basicColor, this.color);
        int beginWidth;
        for(int index = this.stringArray.length - 1; index >= 0; index--)
        {
            beginWidth = (graphics.getFont().stringWidth(this.stringArray[index]) >> 1);
            graphics.drawString(this.stringArray[index], 
                    displayInfo.getLastHalfWidth() - beginWidth, 
                    displayInfo.getLastHalfHeight() - lineArray[index], anchor);
        }
    }
    private final String BEGIN_LEVEL = "Begin Level ";
    private final String EMPTY_STRING = StringUtil.getInstance().EMPTY_STRING;
    public void update()
    {
        int level = gameCanvas.getLayerManager().getGameInfo().getCurrentLevel();
        this.stringArray[0] = BEGIN_LEVEL + level;
        for(int index = this.stringArray.length - 1; index >= 1; index--)
        {
            this.stringArray[index] = this.EMPTY_STRING;
        }
    }
    public void setBasicColor(BasicColor basicColor)
    {
        this.basicColor = basicColor;
    }
    public BasicColor getBasicColor()
    {
        return basicColor;
    }
}