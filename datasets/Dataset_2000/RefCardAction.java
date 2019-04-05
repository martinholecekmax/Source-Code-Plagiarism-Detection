public class RefCardAction extends AnAction implements DumbAware {
  @NonNls private static final String KEYMAP_URL = PathManager.getHomePath() + "/help/" + (SystemInfo.isMac ? "ReferenceCardForMac.pdf" : "ReferenceCard.pdf");
  public void actionPerformed(AnActionEvent e) {
    final String url = KEYMAP_URL;
    if (new File(url).isFile()) {
      BrowserUtil.launchBrowser(url);
    }
    else {
      final ApplicationInfoEx appInfo = ApplicationInfoEx.getInstanceEx();
      String webUrl = SystemInfo.isMac ? appInfo.getMacKeymapUrl() : appInfo.getWinKeymapUrl();
      if (webUrl != null) {
        BrowserUtil.launchBrowser(webUrl);
      }
    }
  }
  public void update(AnActionEvent e) {
    super.update(e);
    boolean atWelcome = ActionPlaces.WELCOME_SCREEN.equals(e.getPlace());
    e.getPresentation().setIcon(atWelcome ? AllIcons.General.DefaultKeymap : null);
  }
}