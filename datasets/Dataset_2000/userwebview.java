public class userwebview extends DroidGap {
    public TestViewClient testViewClient;
    public TestChromeClient testChromeClient;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        testViewClient = new TestViewClient(this);
        testChromeClient = new TestChromeClient(this);
        super.init(new CordovaWebView(this), new TestViewClient(this), new TestChromeClient(this));
        super.loadUrl("file:    }
    public class TestChromeClient extends CordovaChromeClient {
        public TestChromeClient(DroidGap arg0) {
            super(arg0);
            LOG.d("userwebview", "TestChromeClient()");
        }
        @Override
        public void onGeolocationPermissionsShowPrompt(String origin, Callback callback) {
            LOG.d("userwebview", "onGeolocationPermissionsShowPrompt(" + origin + ")");
            super.onGeolocationPermissionsShowPrompt(origin, callback);
            callback.invoke(origin, true, false);
        }
    }
    
    public class TestViewClient extends CordovaWebViewClient {
        public TestViewClient(DroidGap arg0) {
            super(arg0);
            LOG.d("userwebview", "TestViewClient()");
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            LOG.d("userwebview", "shouldOverrideUrlLoading(" + url + ")");
            return super.shouldOverrideUrlLoading(view, url);
        }
        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            LOG.d("userwebview", "onReceivedError: Error code=" + errorCode + " Description=" + description + " URL=" + failingUrl);
            super.onReceivedError(view, errorCode, description, failingUrl);
        }
    }
}