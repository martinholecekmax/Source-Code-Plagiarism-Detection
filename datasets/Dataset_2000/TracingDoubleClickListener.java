public class TracingDoubleClickListener implements IDoubleClickListener {
	public void doubleClick(final DoubleClickEvent event) {
				TreeViewer traceComponentViewer = (TreeViewer) event.getViewer();
		final Object selectedItem = ((IStructuredSelection) traceComponentViewer.getSelection()).getFirstElement();
		final boolean expandedState = traceComponentViewer.getExpandedState(selectedItem);
		if (selectedItem instanceof TracingNode) {
			traceComponentViewer.setExpandedState(selectedItem, !expandedState);
		}
	}
}