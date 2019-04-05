public class ResetSorterAction extends TestBrowserAction {
    public ResetSorterAction(String label, TestBrowser browser) {
        super(label, browser);
    }
    public void run() {
        Viewer viewer = getBrowser().getViewer();
        if (viewer instanceof StructuredViewer) {
            StructuredViewer v = (StructuredViewer) viewer;
            v.setSorter(null);
        }
    }
}