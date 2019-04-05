public class DefaultFileFilterTest extends TestCase {
  public void testResolveDepenencies() throws Exception {
    DefaultFileFilter filter = new DefaultFileFilter();
    FileInfo changed = new FileInfo("foo2.js", -1, -1, false, false, "");
    FileInfo reloaded = new FileInfo("foo3.js", -1, -1, false, false, "");
    List<FileInfo> files = Lists.newArrayList(
      new FileInfo("foo1.js", -1, -1, false, false, ""),
      changed,
      reloaded
    );
    assertEquals(Lists.newArrayList(changed, reloaded),
        filter.resolveFilesDeps(changed, files));
  }
}