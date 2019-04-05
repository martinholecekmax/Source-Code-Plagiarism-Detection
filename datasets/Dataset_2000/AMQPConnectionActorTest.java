public class AMQPConnectionActorTest extends BaseConnectionActorTestCase
{
    @Override
    public void configure()
    {
            }
    @Override
    public void createBroker()
    {
            }
    
    public void testConnection() throws Exception
    {
        getConfigXml().setProperty("status-updates", "ON");
        super.createBroker();
        final String message = sendLogMessage();
        List<Object> logs = _rawLogger.getLogMessages();
        assertEquals("Message log size not as expected.", 1, logs.size());
                assertTrue("Message was not found in log message",
                   logs.get(0).toString().contains(message));
                assertTrue("Message does not contain the [con: prefix",
                   logs.get(0).toString().contains("[con:"));
                        assertFalse("Verify that the string does not contain any '{'.",
                    logs.get(0).toString().contains("{"));
                assertFalse("Message was logged with a channel identifier." + logs.get(0),
                    logs.get(0).toString().contains("/ch:"));
    }
    public void testConnectionLoggingOff() throws Exception, AMQException
    {
        getConfigXml().setProperty("status-updates", "OFF");
                super.createBroker();
        sendLogMessage();
        List<Object> logs = _rawLogger.getLogMessages();
        assertEquals("Message log size not as expected.", 0, logs.size());
    }
    private String sendLogMessage()
    {
        final String message = "test logging";
        _amqpActor.message(new LogSubject()
        {
            public String toLogString()
            {
                return "[AMQPActorTest]";
            }
        }, new LogMessage()
        {
            public String toString()
            {
                return message;
            }
            public String getLogHierarchy()
            {
                return "test.hieracrchy";
            }
        });
        return message;
    }
}