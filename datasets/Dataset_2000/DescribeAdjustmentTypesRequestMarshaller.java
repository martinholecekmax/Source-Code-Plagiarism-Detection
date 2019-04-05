public class DescribeAdjustmentTypesRequestMarshaller implements Marshaller<Request<DescribeAdjustmentTypesRequest>, DescribeAdjustmentTypesRequest> {
    public Request<DescribeAdjustmentTypesRequest> marshall(DescribeAdjustmentTypesRequest describeAdjustmentTypesRequest) {
        if (describeAdjustmentTypesRequest == null) {
		    throw new AmazonClientException("Invalid argument passed to marshall(...)");
		}
        Request<DescribeAdjustmentTypesRequest> request = new DefaultRequest<DescribeAdjustmentTypesRequest>(describeAdjustmentTypesRequest, "AmazonAutoScaling");
        request.addParameter("Action", "DescribeAdjustmentTypes");
        request.addParameter("Version", "2011-01-01");
        return request;
    }
}