public class FieldsWithGenericDebuggee extends SyncDebuggee {
    static long staticLongField;
    String[] stringArrayField;
    Object[] objectArrayField;
    Class classObjectField;
    public void run() {
        synchronizer.sendMessage(JPDADebuggeeSynchronizer.SGNL_READY);
        logWriter.println("--> Debuggee: FieldsWithGenericDebuggee...");
        synchronizer.receiveMessage(JPDADebuggeeSynchronizer.SGNL_CONTINUE);
    }
    public static void main(String [] args) {
        runDebuggee(FieldsWithGenericDebuggee.class);
    }
}