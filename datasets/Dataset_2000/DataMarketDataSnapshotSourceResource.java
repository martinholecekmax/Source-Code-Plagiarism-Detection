@Path("snapshotSource")
public class DataMarketDataSnapshotSourceResource extends AbstractDataResource {
  
  private final MarketDataSnapshotSource _snpSource;
  
  public DataMarketDataSnapshotSourceResource(final MarketDataSnapshotSource snapshotSource) {
    ArgumentChecker.notNull(snapshotSource, "snapshotSource");
    _snpSource = snapshotSource;
  }
    
  public MarketDataSnapshotSource getMarketDataSnapshotSource() {
    return _snpSource;
  }
    @GET
  public Response getHateaos(@Context UriInfo uriInfo) {
    return hateoasResponse(uriInfo);
  }
  @GET
  @Path("snapshots/{snapshotId}")
  public Response get(
      @PathParam("snapshotId") String idStr,
      @QueryParam("version") String version) {
    final ObjectId objectId = ObjectId.parse(idStr);
    final StructuredMarketDataSnapshot result = getMarketDataSnapshotSource().getSnapshot(objectId.atVersion(version));
    return responseOkFudge(result);
  }
    
  public static URI uriGet(URI baseUri, UniqueId uniqueId) {
    UriBuilder bld = UriBuilder.fromUri(baseUri).path("snapshots/{snapshotId}");
    if (uniqueId.getVersion() != null) {
      bld.queryParam("version", uniqueId.getVersion());
    }
    return bld.build(uniqueId.getObjectId());
  }
}