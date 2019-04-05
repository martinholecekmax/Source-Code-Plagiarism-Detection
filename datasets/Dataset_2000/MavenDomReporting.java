public interface MavenDomReporting extends MavenDomElement {
  
  @NotNull
  GenericDomValue<Boolean> getExcludeDefaults();
  
  @NotNull
  @Convert(value = MavenDirectoryPathReferenceConverter.class, soft = true)
  GenericDomValue<PathReference> getOutputDirectory();
  
  @NotNull
  MavenDomPlugins getPlugins();
}