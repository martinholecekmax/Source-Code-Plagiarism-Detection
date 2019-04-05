public class AppContextLeakPreventer extends AbstractLeakPreventer
{
    
    @Override
    public void prevent(ClassLoader loader)
    {
        LOG.debug("Pinning classloader for AppContext.getContext() with "+loader);
        ImageIO.getUseCache();
    }
}