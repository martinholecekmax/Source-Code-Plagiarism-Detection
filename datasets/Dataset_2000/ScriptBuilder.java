public interface ScriptBuilder extends ElementBuilderBase<ScriptBuilder> {
  String UNSUPPORTED_HTML = "Script elements do not support html.  Use text() instead.";
  
  ScriptBuilder defer(String defer);
  
  ScriptBuilder src(String src);
  
  ScriptBuilder type(String type);
}