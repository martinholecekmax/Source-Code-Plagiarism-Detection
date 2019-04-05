@SuppressWarnings("rawtypes")
public class WhatNextActivity extends BaseActivity {
    @Override
    protected Integer getHelpDialog() {
        return null;
    }
    
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_whats_next);
        super.initTitleBarViews();
        setTitleBarTitle(R.string.titleBarWhatNext);
    }
    
    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.examples, menu);
        return true;
    }
    
    @Override
    public boolean onPrepareOptionsMenu(final Menu menu) {
        menu.findItem(R.id.m_next).setVisible(false);
        return super.onPrepareOptionsMenu(menu);
    }
    
    @Override
    public boolean onMenuItemSelected(final int featureId, final MenuItem item) {
        return super.onMenuItemSelected(featureId, item);
    }
    
    @Override
    protected void onUserChanged() {
    }
}