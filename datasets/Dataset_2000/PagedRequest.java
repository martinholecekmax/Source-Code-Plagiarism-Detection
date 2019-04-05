public class PagedRequest<V> extends GitHubRequest {
	
	public static final int PAGE_FIRST = 1;
	
	public static final int PAGE_SIZE = 100;
	private final int pageSize;
	private final int page;
	
	public PagedRequest() {
		this(PAGE_FIRST, PAGE_SIZE);
	}
	
	public PagedRequest(int start, int size) {
		page = start;
		pageSize = size;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	@Override
	protected void addParams(final StringBuilder uri) {
		super.addParams(uri);
		final int size = getPageSize();
		if (size > 0)
			UrlUtils.addParam(PARAM_PER_PAGE, Integer.toString(size), uri);
		final int number = getPage();
		if (number > 0)
			UrlUtils.addParam(PARAM_PAGE, Integer.toString(number), uri);
	}
	
	public int getPage() {
		return page;
	}
}