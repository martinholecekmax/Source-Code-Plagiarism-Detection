public class VerifySessionStateStackTracesHook implements ExecuteWithHookContext {
  public void run(HookContext hookContext) {
    LogHelper console = SessionState.getConsole();
    for (Entry<String, List<List<String>>> entry :
        SessionState.get().getStackTraces().entrySet()) {
      for (List<String> stackTrace : entry.getValue()) {
                                        console.printError(StringUtils.substringAfter(
            StringUtils.substringAfter(stackTrace.get(0), " "), " "));
      }
    }
  }
}