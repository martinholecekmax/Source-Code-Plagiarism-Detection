public class DeleteRoleRequestMarshaller implements Marshaller<Request<DeleteRoleRequest>, DeleteRoleRequest> {
    public Request<DeleteRoleRequest> marshall(DeleteRoleRequest deleteRoleRequest) {
        if (deleteRoleRequest == null) {
		    throw new AmazonClientException("Invalid argument passed to marshall(...)");
		}
        Request<DeleteRoleRequest> request = new DefaultRequest<DeleteRoleRequest>(deleteRoleRequest, "AmazonIdentityManagement");
        request.addParameter("Action", "DeleteRole");
        request.addParameter("Version", "2010-05-08");
        if (deleteRoleRequest.getRoleName() != null) {
            request.addParameter("RoleName", StringUtils.fromString(deleteRoleRequest.getRoleName()));
        }
        return request;
    }
}