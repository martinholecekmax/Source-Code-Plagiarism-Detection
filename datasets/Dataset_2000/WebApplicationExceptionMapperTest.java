public class WebApplicationExceptionMapperTest extends TestExceptionMapperBase {
    @Test
    public void handleExceptionWithResponse() {
        Response mockr = mock(Response.class);
        when(mockr.getStatus()).thenReturn(500);
        WebApplicationException nfe = new WebApplicationException(mockr);
        WebApplicationExceptionMapper nfem =
            injector.getInstance(WebApplicationExceptionMapper.class);
        Response r = nfem.toResponse(nfe);
        assertEquals(500, r.getStatus());
        verifyMessage(r, rtmsg(null));
    }
    @Override
    public Class getMapperClass() {
        return WebApplicationExceptionMapper.class;
    }
}