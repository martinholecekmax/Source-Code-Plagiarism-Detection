public class SMSSendResponse implements java.io.Serializable {
	private static final long serialVersionUID = 1746683143328583536L;
	
	int httpResponseCode=0;
	
	String contentType=null;
	
	RequestError requestError=null;
	
	public int getHTTPResponseCode() { return httpResponseCode; }
	
	public String getContentType() { return contentType; }
	
	public RequestError getRequestError() { return requestError; }
	
	public void setHTTPResponseCode(int httpResponseCode) { this.httpResponseCode=httpResponseCode; }
	
	public void setContentType(String contentType) { this.contentType=contentType; }
	
	public void setRequestError(RequestError requestError) { this.requestError=requestError; }
	
	String location=null;
	
	public String getLocation() { return location; }
	
	public void setLocation(String location) { this.location=location; }
	
	ResourceReference resourceReference=null;
	
	public ResourceReference getResourceReference() { return resourceReference; }
	
	public void setResourceReference(ResourceReference resourceReference) { this.resourceReference=resourceReference; }
	
	public String toString() {
		StringBuffer buffer=new StringBuffer();
		buffer.append("httpResponseCode = "+httpResponseCode);
		buffer.append(", contentType = "+contentType);
		if (requestError!=null) {
			buffer.append(", requestError = {");
			buffer.append(requestError.toString());
			buffer.append("}");
		}
		if (resourceReference!=null) {
			buffer.append(", resourceReference = {");
			buffer.append(resourceReference.toString());
			buffer.append("}");
		}
		return buffer.toString();
	}
}