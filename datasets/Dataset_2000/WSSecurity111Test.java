public class WSSecurity111Test extends WSSecurity11Common {
    private static boolean unrestrictedPoliciesInstalled;
    static {
        unrestrictedPoliciesInstalled = SecurityTestUtil.checkUnrestrictedPoliciesInstalled();
    };
    @BeforeClass
    public static void startServers() throws Exception {
        if (unrestrictedPoliciesInstalled) {
            assertTrue(
                    "Server failed to launch",
                                                            launchServer(Server11.class, true)
            );
        } else {
            if (WSSecurity11Common.isIBMJDK16()) {
                System.out.println("Not running as there is a problem with 1.6 jdk and restricted jars");
                return;
            }
            assertTrue(
                    "Server failed to launch",
                                                            launchServer(Server11Restricted.class, true)
            );
        }
    }
    @org.junit.AfterClass
    public static void cleanup() throws Exception {
        SecurityTestUtil.cleanup();
        stopAllServers();
    }
    @Test
    public void testClientServer() throws IOException {
        if ((!unrestrictedPoliciesInstalled)
                && (WSSecurity11Common.isIBMJDK16())) {
            System.out.println("Not running as there is a problem with 1.6 jdk and restricted jars");
            return;
        }
        String[] argv = new String[] {
            "A",
            "A-NoTimestamp",
            "AD",
            "A-ES",
            "AD-ES",
            "UX",
            "UX-NoTimestamp",
            "UXD",
            "UX-SEES",
            "UXD-SEES", 
        };
        runClientServer(argv, unrestrictedPoliciesInstalled, false);
    }
}