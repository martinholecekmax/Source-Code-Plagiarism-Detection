public class ClojureConsoleProcessHandler extends ColoredProcessHandler {
  private final LanguageConsoleImpl myLanguageConsole;
  public ClojureConsoleProcessHandler(Process process, String commandLine, LanguageConsoleImpl console) {
    super(process, commandLine, CharsetToolkit.UTF8_CHARSET);
    myLanguageConsole = console;
  }
  @Override
  protected void textAvailable(String text, Key attributes) {
    final String string = processPrompts(myLanguageConsole, StringUtil.convertLineSeparators(text));
    ClojureConsoleHighlightingUtil.processOutput(myLanguageConsole, string, attributes);
  }
  private static String processPrompts(final LanguageConsoleImpl console, String text) {
    if (text != null && text.matches(ClojureConsoleHighlightingUtil.LINE_WITH_PROMPT)) {
      final Matcher matcher = ClojureConsoleHighlightingUtil.CLOJURE_PROMPT_PATTERN.matcher(text);
      matcher.find();
      final String prefix = matcher.group();
      final String trimmed = StringUtil.trimStart(text, prefix).trim();
      console.setPrompt(prefix + " ");
      return trimmed;
    }
    return text;
  }
  public LanguageConsoleImpl getLanguageConsole() {
    return myLanguageConsole;
  }
}