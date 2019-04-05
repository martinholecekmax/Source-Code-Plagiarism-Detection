public class CodeBlockProviders extends LanguageExtension<CodeBlockProvider> {
  public static CodeBlockProviders INSTANCE = new CodeBlockProviders();
  private CodeBlockProviders() {
    super("com.intellij.codeBlockProvider");
  }
}