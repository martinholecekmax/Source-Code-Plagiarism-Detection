public class InventoryRouteDefer extends RouteBuilder {
    @Override
    public void configure() throws Exception {
                from("cxf:bean:inventoryEndpoint")
            .routeId("webservice").startupOrder(3)
            .to("direct:update")
            .transform().method("inventoryService", "replyOk");
                from("file:            .routeId("file").startupOrder(2)
            .split(body().tokenize("\n"))
            .convertBodyTo(UpdateInventoryInput.class)
            .to("direct:update");
                from("direct:update")
            .routeId("update").startupOrder(1)
                        .shutdownRoute(ShutdownRoute.Defer)
            .to("bean:inventoryService?method=updateInventory");
    }
}