public class GraphViewStyleAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/xtext/graphview/style/parser/antlr/internal/InternalGraphViewStyle.tokens");
	}
}