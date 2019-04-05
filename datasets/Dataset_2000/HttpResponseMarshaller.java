public abstract class HttpResponseMarshaller<To> implements IMarshaller<HttpResponse, To> {
    @Override
    public To marshall(HttpResponse content) throws IOException, MarshallingException {
        if (content == null)
            throw new IOException("response can not be null");
        StatusLine statusLine = content.getStatusLine();
        
        if (statusLine.getStatusCode() == HttpStatus.SC_NO_CONTENT) {
            throw new HttpControlFlow(HttpStatus.SC_NO_CONTENT);
        }
        BufferedHttpEntity entity = new BufferedHttpEntity(content.getEntity());
        return marshall(entity.getContent());
    }
    protected abstract To marshall(InputStream content) throws IOException, MarshallingException;
}