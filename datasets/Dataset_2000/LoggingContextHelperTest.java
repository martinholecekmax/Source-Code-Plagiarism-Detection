public class LoggingContextHelperTest {
    Mockery context = new JUnit4Mockery() {
        {
            setImposteriser(ClassImposteriser.INSTANCE);
        }
    };
    final Log mockLog = context.mock(Log.class);
    public LoggingContextHelperTest() {
    }
    @BeforeClass
    public static void setUpClass() throws Exception {
    }
    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    @Before
    public void setUp() {
    }
    @After
    public void tearDown() {
    }
    @Test
    public void testCreateLogger() {
        try {
            LoggingContextHelper loggingContextHelper = new LoggingContextHelper() {
                @Override
                protected Log createLogger() {
                    return mockLog;
                }
            };
            Log log = loggingContextHelper.createLogger();
            assertNotNull("Log was null", log);
        } catch (Throwable t) {
            System.out.println("Error running testCreateLogger test: " + t.getMessage());
            t.printStackTrace();
            fail("Error running testCreateLogger test: " + t.getMessage());
        }
    }
    @Test
    public void testLoggingContext() {
        LoggingContextHelper loggingContextHelper = new LoggingContextHelper() {
            @Override
            protected String generateLoggingContextId(WebServiceContext webServiceContext) {
                return "TestUUID";
            }
        };
        try {
                        loggingContextHelper.setContext(null);
                        assertEquals("Nested diagnostic context is not properly constructed. ", 1, NDC.getDepth());
            assertEquals("Context contents are not successfully generated. ", "TestUUID", NDC.peek());
        } finally {
            loggingContextHelper.clearContext();
            assertEquals("Nested diagnostic context is not properly cleared. ", 0, NDC.getDepth());
        }
    }
}