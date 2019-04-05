public class GradleTextAttributes {
  
  public static final TextAttributesKey GRADLE_LOCAL_CHANGE = TextAttributesKey.createTextAttributesKey(
    "GRADLE_LOCAL_CHANGE",
    new TextAttributes(new Color(130, 184, 22), null, null, null, Font.PLAIN)
  );
  
  public static final TextAttributesKey INTELLIJ_LOCAL_CHANGE = TextAttributesKey.createTextAttributesKey(
    "INTELLIJ_LOCAL_CHANGE",
    new TextAttributes(new Color(16, 102, 248), null, null, null, Font.PLAIN)
  );
  
  public static final TextAttributesKey CHANGE_CONFLICT = TextAttributesKey.createTextAttributesKey(
    "GRADLE_CHANGE_CONFLICT",
    new TextAttributes(new Color(238, 0, 0), null, null, null, Font.PLAIN)
  );
  
  public static final TextAttributesKey NO_CHANGE = TextAttributesKey.createTextAttributesKey(
    "GRADLE_NO_CHANGE",
    new TextAttributes(Color.BLACK, null, null, null, Font.PLAIN)
  );
  
  public static final TextAttributesKey CONFIRMED_CONFLICT = TextAttributesKey.createTextAttributesKey(
    "GRADLE_CONFIRMED_CONFLICT",
    new TextAttributes(Gray._140, null, null, null, Font.PLAIN)
  );
  private GradleTextAttributes() {
  }
}