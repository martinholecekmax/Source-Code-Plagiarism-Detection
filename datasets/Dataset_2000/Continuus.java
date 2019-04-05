public abstract class Continuus extends Task {
    private String ccmDir = "";
    private String ccmAction = "";
    
    public String getCcmAction() {
        return ccmAction;
    }
    
    public void setCcmAction(String v) {
        this.ccmAction = v;
    }
    
    public final void setCcmDir(String dir) {
        ccmDir = FileUtils.translatePath(dir);
    }
    
    protected final String getCcmCommand() {
        String toReturn = ccmDir;
        if (!toReturn.equals("") && !toReturn.endsWith("/")) {
            toReturn += "/";
        }
        toReturn += CCM_EXE;
        return toReturn;
    }
    
    protected int run(Commandline cmd, ExecuteStreamHandler handler) {
        try {
            Execute exe = new Execute(handler);
            exe.setAntRun(getProject());
            exe.setWorkingDirectory(getProject().getBaseDir());
            exe.setCommandline(cmd.getCommandline());
            return exe.execute();
        } catch (java.io.IOException e) {
            throw new BuildException(e, getLocation());
        }
    }
    
    protected int run(Commandline cmd) {
        return run(cmd, new LogStreamHandler(this, Project.MSG_VERBOSE, Project.MSG_WARN));
    }
    
    private static final String CCM_EXE = "ccm";
    
    public static final String COMMAND_CREATE_TASK = "create_task";
    
    public static final String COMMAND_CHECKOUT = "co";
    
    public static final String COMMAND_CHECKIN = "ci";
    
    public static final String COMMAND_RECONFIGURE = "reconfigure";
    
    public static final String COMMAND_DEFAULT_TASK = "default_task";
}