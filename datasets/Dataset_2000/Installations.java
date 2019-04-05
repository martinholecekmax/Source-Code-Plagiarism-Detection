@Path("inst")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Installations {
	
	@GET
	public String getInstallations(
			@QueryParam("scn_id") String scn_id,
			@QueryParam("filter") String filters,
			@QueryParam("sort") String sort,
			@QueryParam("limit") int limit,
			@QueryParam("skip") int skip,
			@QueryParam("count") boolean count,
			@QueryParam("pertype") boolean pertype,
			@Context HttpHeaders httpHeaders) {
		return PrettyJSONPrinter.prettyPrint(new MongoInstallations().
				getInstallations(httpHeaders,scn_id,filters,sort, limit,skip,count,pertype));
	}
	
	@POST
	public String createInstallation(String message) {
		return PrettyJSONPrinter.prettyPrint(new MongoInstallations().createInstallation(message));
	}
}