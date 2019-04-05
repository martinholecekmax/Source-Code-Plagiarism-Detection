public class AxisConnectorTestCase extends AbstractConnectorTestCase
{
    public String getTestEndpointURI()
    {
        return "axis:http:    }
    public Connector createConnector() throws Exception
    {
        AxisConnector c = new AxisConnector(muleContext);
        c.setName("axisConnector");
        return c;
    }
    public Object getValidMessage() throws Exception
    {
        return "Test Message";
    }
}