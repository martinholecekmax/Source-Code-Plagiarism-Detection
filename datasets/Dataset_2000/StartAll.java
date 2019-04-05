public class StartAll extends Test {
  @Override
  public void visit(State state, Properties props) throws Exception {
    log.info("Starting all servers");
    Process exec = Runtime.getRuntime().exec(new String[]{System.getenv().get("ACCUMULO_HOME") + "/bin/start-all.sh"});
    exec.waitFor();
  }
}