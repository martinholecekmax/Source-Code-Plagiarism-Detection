public class K9Activity extends SherlockActivity implements K9ActivityMagic {
    private K9ActivityCommon mBase;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        mBase = K9ActivityCommon.newInstance(this);
        super.onCreate(savedInstanceState);
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        mBase.preDispatchTouchEvent(event);
        return super.dispatchTouchEvent(event);
    }
    @Override
    public int getThemeBackgroundColor() {
        return mBase.getThemeBackgroundColor();
    }
    @Override
    public void setupGestureDetector(OnSwipeGestureListener listener) {
        mBase.setupGestureDetector(listener);
    }
}