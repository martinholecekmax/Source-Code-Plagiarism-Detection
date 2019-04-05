public class MediaDump extends TabActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
                setContentView(R.layout.main);
        TabHost tab = getTabHost();
                TabHost.TabSpec videoDumpTab = tab.newTabSpec("VideoDump");
        videoDumpTab.setIndicator("VideoDump");
        Intent videoDumpIntent = new Intent(this, VideoDumpActivity.class);
        videoDumpTab.setContent(videoDumpIntent);
        tab.addTab(videoDumpTab);
                TabHost.TabSpec rgbPlayerTab = tab.newTabSpec("RgbPlayer");
        rgbPlayerTab.setIndicator("RgbPlayer");
        Intent rgbPlayerIntent = new Intent(this, RgbPlayerActivity.class);
        rgbPlayerTab.setContent(rgbPlayerIntent);
        tab.addTab(rgbPlayerTab);
    }
}