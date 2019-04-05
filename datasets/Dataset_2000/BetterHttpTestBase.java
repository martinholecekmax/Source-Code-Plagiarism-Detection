@RunWith(PowerMockRunner.class)
@PrepareForTest({ Log.class })
public class BetterHttpTestBase extends TestBase {
    protected String responseBody = "Here be Jason.";
    protected String url = "http:    @Mock
    protected AbstractHttpClient httpClientMock;
    @Mock
    protected BetterHttpResponse mockResponse;
    @SuppressWarnings("unchecked")
    @Before
    public void setupHttpClient() throws Exception {
        when(mockResponse.getResponseBody()).thenReturn(
                new ByteArrayInputStream(responseBody.getBytes()));
        when(mockResponse.getResponseBodyAsBytes()).thenReturn(responseBody.getBytes());
        when(mockResponse.getResponseBodyAsString()).thenReturn(responseBody);
        when(mockResponse.getStatusCode()).thenReturn(200);
        when(
                httpClientMock.execute(any(HttpUriRequest.class), any(ResponseHandler.class),
                        any(HttpContext.class))).thenReturn(mockResponse);
        BasicHttpParams params = new BasicHttpParams();
        HttpConnectionParams.setSoTimeout(params, BetterHttp.DEFAULT_SOCKET_TIMEOUT);
        when(httpClientMock.getParams()).thenReturn(params);
        BetterHttp.setHttpClient(httpClientMock);
    }
}