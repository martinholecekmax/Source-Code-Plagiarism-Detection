public class MockHttpClient extends HttpClient {
	private int returnCode;
	private Exception exception;
	public MockHttpClient(int retCode){
		returnCode = retCode;
	}
	public MockHttpClient(Exception e){
		exception = e;
	}
	public int executeMethod(HttpMethod m)  throws IOException, HttpException{
		if(exception instanceof IOException)
			throw (IOException)exception;
		if(exception instanceof HttpException)
			throw (HttpException)exception;
		return returnCode;
	}
}