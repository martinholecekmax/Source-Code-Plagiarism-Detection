public class DtoDataProviderTest extends BaseWicketTest
{
    
    @Test
    public void testExplicitIterate() throws Exception
    {
        DtoDataProviderTestPage page = assertRenderAndClickNext(0);
        BeanResultProvider provider = page.getProvider();
        Iterator<? extends Bean> iter = provider.iterator(0, provider.size());
        List<Bean> list = new ArrayList<Bean>(100);
        while(iter.hasNext())
        {
            list.add(iter.next());
        }
        Assert.assertEquals(100, list.size());
        Assert.assertEquals(2, provider.getLoadCount());
    }
    @Test
    public void testRender() throws Exception
    {
        assertRenderAndClickNext(0);
    }
    @Test
    public void testRender_clickNext() throws Exception
    {
        assertRenderAndClickNext(1);
    }
    @Test
    public void testRender_clickNextTwice() throws Exception
    {
        assertRenderAndClickNext(2);
    }
    private DtoDataProviderTestPage assertRenderAndClickNext(int clicks) throws Exception
    {
        DtoDataProviderTestPage page = new DtoDataProviderTestPage();
        this.tester.startPage(page);
        for(int i=0; i<clicks; i++)
        {
            this.tester.clickLink("paging:next");
        }
        this.tester.assertResultPage(
            DtoDataProviderTestPage.class,
            String.format("DtoDataProviderTestPage-%d-expected.html", clicks)
        );
                Assert.assertEquals(1 + clicks, page.getLoadCount());
        return page;
    }
}