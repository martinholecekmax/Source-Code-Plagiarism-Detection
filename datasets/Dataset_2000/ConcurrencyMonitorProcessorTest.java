public class ConcurrencyMonitorProcessorTest extends TestCase {
        private ConcurrencyMonitorProcessor concurrencyMonitorProcessor = new ConcurrencyMonitorProcessor();
    private MockMonitorProcessor mockMonitorProcessor = new MockMonitorProcessor();
        protected void setUp()
            throws Exception {
        super.setUp();
        MonitorProcessor[] processors = new MonitorProcessor[2];
        processors[0] = concurrencyMonitorProcessor;
        processors[1] = mockMonitorProcessor;
        MonitoringEngine.getInstance().setProcessorFactory(
                new MockMonitorProcessorFactory(processors));
        MonitoringEngine.getInstance().setDecomposer(new MockDecomposer());
        MonitoringEngine.getInstance().startup();
    }
    protected void tearDown()
            throws Exception {
        super.tearDown();
        MonitoringEngine.getInstance().shutdown();
    }
        public void testConcurrency() {
        TransactionMonitor monitor = new TransactionMonitor("Test");
        monitor.done();
        assertEquals("concurrency s/b 1", 1, monitor.getAsInt("concurrencyCount"));
        mockMonitorProcessor.clear();
        monitor = new TransactionMonitor("Test");
        TransactionMonitor monitor2 = new TransactionMonitor("Test");
        monitor2.done();
        assertEquals("concurrency for Test s/b 2", 2, monitor2.getAsInt("concurrencyCount"));
        monitor.done();
        assertEquals("concurrency for Test s/b 1", 1, monitor.getAsInt("concurrencyCount"));
        Map map = concurrencyMonitorProcessor.getAll();
        int c = ((Integer) map.get("Test")).intValue();
        assertEquals("concurrency for Test s/b 0", 0, c);        
        mockMonitorProcessor.clear();
    }
}