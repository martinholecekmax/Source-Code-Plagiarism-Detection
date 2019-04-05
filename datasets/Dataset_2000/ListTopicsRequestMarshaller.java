public class ListTopicsRequestMarshaller implements Marshaller<Request<ListTopicsRequest>, ListTopicsRequest> {
    public Request<ListTopicsRequest> marshall(ListTopicsRequest listTopicsRequest) {
        if (listTopicsRequest == null) {
		    throw new AmazonClientException("Invalid argument passed to marshall(...)");
		}
        Request<ListTopicsRequest> request = new DefaultRequest<ListTopicsRequest>(listTopicsRequest, "AmazonSNS");
        request.addParameter("Action", "ListTopics");
        request.addParameter("Version", "2010-03-31");
        if (listTopicsRequest.getNextToken() != null) {
            request.addParameter("NextToken", StringUtils.fromString(listTopicsRequest.getNextToken()));
        }
        return request;
    }
}