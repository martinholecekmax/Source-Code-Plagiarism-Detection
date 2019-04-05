public class GetSessionTokenRequestMarshaller implements Marshaller<Request<GetSessionTokenRequest>, GetSessionTokenRequest> {
    public Request<GetSessionTokenRequest> marshall(GetSessionTokenRequest getSessionTokenRequest) {
        if (getSessionTokenRequest == null) {
		    throw new AmazonClientException("Invalid argument passed to marshall(...)");
		}
        Request<GetSessionTokenRequest> request = new DefaultRequest<GetSessionTokenRequest>(getSessionTokenRequest, "AWSSecurityTokenService");
        request.addParameter("Action", "GetSessionToken");
        request.addParameter("Version", "2011-06-15");
        if (getSessionTokenRequest.getDurationSeconds() != null) {
            request.addParameter("DurationSeconds", StringUtils.fromInteger(getSessionTokenRequest.getDurationSeconds()));
        }
        if (getSessionTokenRequest.getSerialNumber() != null) {
            request.addParameter("SerialNumber", StringUtils.fromString(getSessionTokenRequest.getSerialNumber()));
        }
        if (getSessionTokenRequest.getTokenCode() != null) {
            request.addParameter("TokenCode", StringUtils.fromString(getSessionTokenRequest.getTokenCode()));
        }
        return request;
    }
}