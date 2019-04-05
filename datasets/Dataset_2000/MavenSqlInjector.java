public class MavenSqlInjector extends MavenPluginConfigurationLanguageInjector {
  public MavenSqlInjector() {
    super("sqlCommand", "org.codehaus.mojo", "sql-maven-plugin", Language.findLanguageByID("SQL"));
  }
}