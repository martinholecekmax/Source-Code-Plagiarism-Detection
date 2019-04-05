public interface RemoteExecution {
  public void executeCommand (String remoteHostName, String user,
          String  command) throws Exception;
  public int getExitCode();
  public String getOutput();
  public String getCommandString();
}