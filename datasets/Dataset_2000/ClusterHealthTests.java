public class ClusterHealthTests extends AbstractNodesTests {
    @AfterMethod
    public void closeNodes() {
        closeAllNodes();
    }
    @Test
    public void testHealth() {
        Node node1 = startNode("node1");
        logger.info("--> running cluster health on an index that does not exists");
        ClusterHealthResponse healthResponse = node1.client().admin().cluster().prepareHealth("test").setWaitForYellowStatus().setTimeout("1s").execute().actionGet();
        assertThat(healthResponse.timedOut(), equalTo(true));
        assertThat(healthResponse.status(), equalTo(ClusterHealthStatus.RED));
    }
}