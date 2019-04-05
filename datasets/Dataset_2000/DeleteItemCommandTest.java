public class DeleteItemCommandTest {
    private DeleteItemCommand command;
    private AmazonDDBClientMock ddbClient;
    private DdbConfiguration configuration;
    private Exchange exchange;
    @Before
    public void setUp() {
        ddbClient = new AmazonDDBClientMock();
        configuration = new DdbConfiguration();
        configuration.setTableName("DOMAIN1");
        exchange = new DefaultExchange(new DefaultCamelContext());
        command = new DeleteItemCommand(ddbClient, configuration, exchange);
    }
    @Test
    public void execute() {
        Key key = new Key(new AttributeValue("Key_1"));
        exchange.getIn().setHeader(DdbConstants.KEY, key);
        Map<String, ExpectedAttributeValue> updateCondition = new HashMap<String, ExpectedAttributeValue>();
        updateCondition
                .put("name", new ExpectedAttributeValue(new AttributeValue("expected value")));
        exchange.getIn().setHeader(DdbConstants.UPDATE_CONDITION, updateCondition);
        exchange.getIn().setHeader(DdbConstants.RETURN_VALUES, "ALL_OLD");
        command.execute();
        assertEquals("DOMAIN1", ddbClient.deleteItemRequest.getTableName());
        assertEquals(key, ddbClient.deleteItemRequest.getKey());
        assertEquals(updateCondition, ddbClient.deleteItemRequest.getExpected());
        assertEquals("ALL_OLD", ddbClient.deleteItemRequest.getReturnValues());
        assertEquals(new AttributeValue("attrValue"),
                exchange.getIn().getHeader(DdbConstants.ATTRIBUTES, Map.class).get(
                        "attrName"));
    }
}