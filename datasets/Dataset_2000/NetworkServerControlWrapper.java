public class NetworkServerControlWrapper {
    private static final int PING = 0;
    private static final int SHUTDOWN = 1;
    private static final int START = 2;
    
    private final Object ctrl;
    
    private final Method[] METHODS = new Method[3];
    
    NetworkServerControlWrapper()
            throws Exception {
                Class clazzSC = null;
        try {
            clazzSC =
                    Class.forName("org.apache.derby.drda.NetworkServerControl");
        } catch (ClassNotFoundException cnfe) {
            BaseTestCase.fail("No runtime support for network server", cnfe);
        }
        Class clazzTS = Class.forName(
                "org.apache.derbyTesting.junit.NetworkServerTestSetup");
        Method m = clazzTS.getMethod("getNetworkServerControl", null);
                this.ctrl = m.invoke(null, null);
                METHODS[PING] = clazzSC.getMethod("ping", null);
        METHODS[SHUTDOWN] = clazzSC.getMethod("shutdown", null);
        METHODS[START] = clazzSC.getMethod(
                "start", new Class[] {PrintWriter.class});
    }
    
    private final void invoke(int methodIndex, Object[] args)
            throws Exception {
        try {
                        METHODS[methodIndex].invoke(this.ctrl, args);
        } catch (IllegalArgumentException iae) {
                        BaseTestCase.fail("Test framework programming error", iae);
        }
    }
        
    public void ping()
            throws Exception {
        invoke(PING, null);
    }
    
    public void shutdown()
            throws Exception {
        invoke(SHUTDOWN, null);
    }
    
    public void start(PrintWriter printWriter)
            throws Exception {
        invoke(START, new Object[] {printWriter});
    }
}