public class CompositeSearchProvider extends SearchProvider {
	private List<SearchProvider> delegates;
	public CompositeSearchProvider() {
		this(new ArrayList<SearchProvider>());
	}
	public CompositeSearchProvider(List<SearchProvider> searchProviders) {
		delegates = searchProviders;
	}
	public List<SearchProvider> getDelegates() {
		return delegates;
	}
	public void setDelegates(List<SearchProvider> delegates) {
		this.delegates = delegates;
	}
	@Override
	public void performSearch(SearchCriteria searchSpecification, SearchCallback callback, IProgressMonitor m)
			throws CoreException {
		SubMonitor monitor = SubMonitor.convert(m);
		final int workPerChild = 10000;
		monitor.beginTask(NLS.bind(Messages.CompositeSearchProvider_SearchingTask, searchSpecification.getText()),
				workPerChild * delegates.size());
		try {
			for (SearchProvider provider : delegates) {
				provider.performSearch(searchSpecification, callback, monitor.newChild(workPerChild));
			}
		} finally {
			monitor.done();
		}
	}
}