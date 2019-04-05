public class TestPACLBlogsEntryLocalServiceImpl
	extends BlogsEntryLocalServiceWrapper {
	public TestPACLBlogsEntryLocalServiceImpl(
		BlogsEntryLocalService blogsEntryLocalService) {
		super(blogsEntryLocalService);
	}
	@Override
	public int getBlogsEntriesCount() {
		return -123;
	}
}