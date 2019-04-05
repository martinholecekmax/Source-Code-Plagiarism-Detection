public class IntroPageTitle extends IntroText {
    protected static final String TAG_TITLE = "title";     IntroPageTitle(Element element, Bundle bundle) {
        super(element, bundle);
    }
    
    public String getTitle() {
        return getText();
    }
    
    public int getType() {
        return AbstractIntroElement.PAGE_TITLE;
    }
}