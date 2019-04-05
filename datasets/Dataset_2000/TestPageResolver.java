public class TestPageResolver extends AbstractMOWTestcase {
  private PageResolver resolver ;
  public void setUp() throws Exception{
    super.setUp() ;
    resolver = (PageResolver)container.getComponentInstanceOfType(PageResolver.class) ;    
  }
  public void testPageResolver() throws Exception{
    assertNotNull(resolver) ;
  }
  public void testExtractParams() throws Exception{
    WikiPageParams params = resolver.extractWikiPageParams("http:    assertNotNull(params) ;    
  }
  public void testGetPage() throws Exception{
    Page page = resolver.resolve("http:    assertNotNull(page) ;    
  }
}