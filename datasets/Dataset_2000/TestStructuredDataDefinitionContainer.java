public class TestStructuredDataDefinitionContainer extends CascadeWebServicesTestCase
{
    private DataDefinitionContainer container;
    private String containerId;
    private String containerPath;
    
    @Override
    protected void onSetUp() throws Exception
    {
        super.onSetUp();
        containerPath = "ws_str_data_def_container";
        container = new DataDefinitionContainer();
        container.setName(containerPath);
        container.setParentContainerId(RootContainerIds.STRUCTURED_DATA_DEF_CONT_ROOT_ID);
        Asset asset = new Asset();
        asset.setDataDefinitionContainer(container);
        containerId = create(asset, EntityTypeString.datadefinitioncontainer);
    }
    
    public void testReadById() throws Exception
    {
        ReadResult rr = client.read(auth, new Identifier(containerId, null, EntityTypeString.datadefinitioncontainer, null));
        assertOperationSuccess(rr, EntityTypeString.datadefinitioncontainer);
        Asset asset = rr.getAsset();
        assertNotNull(asset);
        DataDefinitionContainer sddc = asset.getDataDefinitionContainer();
        assertNotNull(sddc);
        assertEquals(sddc.getName(), container.getName());
        assertEquals(sddc.getParentContainerId(), container.getParentContainerId());
    }
    
    public void testReadByPath() throws Exception
    {
        ReadResult rr = client.read(auth, new Identifier(null, new Path(containerPath, null, "Global"), EntityTypeString.datadefinitioncontainer,
                null));
        assertOperationSuccess(rr, EntityTypeString.datadefinitioncontainer);
        Asset asset = rr.getAsset();
        assertNotNull(asset);
        DataDefinitionContainer sddc = asset.getDataDefinitionContainer();
        assertNotNull(sddc);
        assertEquals(sddc.getName(), container.getName());
        assertEquals(sddc.getParentContainerId(), container.getParentContainerId());
    }
}