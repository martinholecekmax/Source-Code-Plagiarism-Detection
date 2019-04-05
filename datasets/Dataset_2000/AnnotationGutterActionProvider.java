public interface AnnotationGutterActionProvider {
  ExtensionPointName<AnnotationGutterActionProvider> EP_NAME = ExtensionPointName.create("com.intellij.vcsAnnotationGutterActionProvider");
  
  @NotNull
  AnAction createAction(FileAnnotation annotation);
}