public class TestProtocolAllowedBehavior extends AbstractProtocolTest {
    @Test
    public void testNonSharedCacheReturnsStaleResponseWhenRevalidationFailsForProxyRevalidate()
        throws Exception {
        HttpRequest req1 = new BasicHttpRequest("GET", "/", HttpVersion.HTTP_1_1);
        Date now = new Date();
        Date tenSecondsAgo = new Date(now.getTime() - 10 * 1000L);
        originResponse.setHeader("Date", DateUtils.formatDate(tenSecondsAgo));
        originResponse.setHeader("Cache-Control","max-age=5,proxy-revalidate");
        originResponse.setHeader("Etag","\"etag\"");
        backendExpectsAnyRequest().andReturn(originResponse);
        HttpRequest req2 = new BasicHttpRequest("GET", "/", HttpVersion.HTTP_1_1);
        backendExpectsAnyRequest().andThrow(new SocketTimeoutException());
        replayMocks();
        behaveAsNonSharedCache();
        impl.execute(host, req1);
        HttpResponse result = impl.execute(host, req2);
        verifyMocks();
        Assert.assertEquals(HttpStatus.SC_OK, result.getStatusLine().getStatusCode());
    }
    @Test
    public void testNonSharedCacheMayCacheResponsesWithCacheControlPrivate()
        throws Exception {
        HttpRequest req1 = new BasicHttpRequest("GET","/", HttpVersion.HTTP_1_1);
        originResponse.setHeader("Cache-Control","private,max-age=3600");
        backendExpectsAnyRequest().andReturn(originResponse);
        HttpRequest req2 = new BasicHttpRequest("GET","/", HttpVersion.HTTP_1_1);
        replayMocks();
        behaveAsNonSharedCache();
        impl.execute(host, req1);
        HttpResponse result = impl.execute(host, req2);
        verifyMocks();
        Assert.assertEquals(HttpStatus.SC_OK, result.getStatusLine().getStatusCode());
    }
}