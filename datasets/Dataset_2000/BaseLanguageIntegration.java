class BaseLanguageIntegration {
  private static Pattern REGEXP_efh9at_a0a0a0a = Pattern.compile("(\\w+)@(\\w+(?:\\.\\w+))", 0);
  private static Pattern REGEXP_efh9at_a0a0a0b = Pattern.compile("(\\d+)", 0);
  private static Pattern REGEXP_efh9at_a0a0a0c = Pattern.compile("(\\d+)", 0);
  private static Pattern REGEXP_efh9at_b0a0a3 = Pattern.compile("\\((.*?)\\)", 0);
  private static Pattern REGEXP_efh9at_b0a0e = Pattern.compile("\\s+", 0);
  public BaseLanguageIntegration() {
  }
  public static void email(String emailToAnalyse) {
    {
      Pattern _pattern_0 = REGEXP_efh9at_a0a0a0a;
      Matcher _matcher_0 = _pattern_0.matcher(emailToAnalyse);
      if (_matcher_0.matches()) {
        System.out.println("User name = " + _matcher_0.group(1));
        System.out.println("Domain = " + _matcher_0.group(2));
      }
    }
  }
  public static void contains(String s) {
    {
      Pattern _pattern_0 = REGEXP_efh9at_a0a0a0b;
      Matcher _matcher_0 = _pattern_0.matcher(s);
      if (_matcher_0.find()) {
        System.out.println(_matcher_0.group(1));
      }
    }
  }
  public static void forEach(String test) {
    {
      Pattern _pattern_0 = REGEXP_efh9at_a0a0a0c;
      Matcher _matcher_0 = _pattern_0.matcher(test);
      while (_matcher_0.find()) {
        System.out.println("number = " + _matcher_0.group(1));
      }
    }
  }
  public static String replaceAll(String s) {
    s = RegexpOperations.replace(s, REGEXP_efh9at_b0a0a3, new _Replacer_efh9at_a0a0a0d(null, null));
    return s;
  }
  public static void split(String s) {
    for (String st : RegexpOperations.split(s, REGEXP_efh9at_b0a0e)) {
      System.out.println("s = " + st);
    }
  }
}