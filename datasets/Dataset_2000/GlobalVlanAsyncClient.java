@RequestFilters(AuthenticationFilter.class)
@QueryParams(keys = "response", values = "json")
public interface GlobalVlanAsyncClient {
   
   @GET
   @QueryParams(keys = { "command", "listAll" }, values = { "listVlanIpRanges", "true" })
   @SelectJson("vlaniprange")
   @OnlyElement
   @Consumes(MediaType.APPLICATION_JSON)
   @ExceptionParser(ReturnNullOnNotFoundOr404.class)
   ListenableFuture<VlanIPRange> getVlanIPRange(@QueryParam("id") String id);
   
   @GET
   @QueryParams(keys = { "command", "listAll" }, values = { "listVlanIpRanges", "true" })
   @SelectJson("vlaniprange")
   @Consumes(MediaType.APPLICATION_JSON)
   @ExceptionParser(ReturnEmptySetOnNotFoundOr404.class)
   ListenableFuture<Set<VlanIPRange>> listVlanIPRanges(ListVlanIPRangesOptions... options);
   
   @GET
   @QueryParams(keys = "command", values = "createVlanIpRange")
   @SelectJson("vlaniprange")
   @Consumes(MediaType.APPLICATION_JSON)
   @ExceptionParser(ReturnNullOnNotFoundOr404.class)
   ListenableFuture<VlanIPRange> createVlanIPRange(@QueryParam("startip") String startIP, @QueryParam("endip") String endIP, CreateVlanIPRangeOptions... options);
   
   @GET
   @QueryParams(keys = "command", values = "deleteVlanIpRange")
   @Consumes(MediaType.APPLICATION_JSON)
   @ExceptionParser(ReturnVoidOnNotFoundOr404.class)
   ListenableFuture<Void> deleteVlanIPRange(@QueryParam("id") String rangeId);
}