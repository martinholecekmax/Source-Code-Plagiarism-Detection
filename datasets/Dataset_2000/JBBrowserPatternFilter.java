public class JBBrowserPatternFilter extends JBPatternFilter {
    
    public boolean isElementVisible(Viewer viewer, Object element) {
        if (element instanceof ICapPO || element instanceof IExecTestCasePO) {
            return false;
        }
        return super.isElementVisible(viewer, element);
    }
}