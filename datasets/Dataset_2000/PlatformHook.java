public interface PlatformHook {
    
    public void preStartupHook();
    
    public void startupHook();
    
    public void openUrl(String url) throws IOException;
    
    public void initSystemShortcuts();
    
    public String makeTooltip(String name, Shortcut sc);
    public String getDefaultStyle();
    public boolean canFullscreen();
    public boolean rename(File from, File to);
}