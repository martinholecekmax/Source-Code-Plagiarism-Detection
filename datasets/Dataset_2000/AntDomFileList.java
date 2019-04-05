public abstract class AntDomFileList extends AntDomFilesProviderImpl{
  @Attribute("dir")
  @Convert(value = AntPathConverter.class)
  public abstract GenericAttributeValue<PsiFileSystemItem> getDir();
  @Attribute("files")
  public abstract GenericAttributeValue<String> getFilesString();
  @SubTagList("file")
  public abstract List<AntDomNamedElement> getFiles();   @Nullable
  protected AntDomPattern getAntPattern() {
    return null;   }
  @NotNull
  protected List<File> getFiles(@Nullable AntDomPattern pattern, Set<AntFilesProvider> processed) {
    final File root = getCanonicalFile(getDir().getStringValue());
    if (root == null) {
      return Collections.emptyList();
    }
    final ArrayList<File> files = new ArrayList<File>();
    final String filenames = getFilesString().getStringValue();
    if (filenames != null) {
      final StringTokenizer tokenizer = new StringTokenizer(filenames, ", \t\n\r\f", false);
      while (tokenizer.hasMoreTokens()) {
        files.add(new File(root, tokenizer.nextToken()));
      }
    }
    for (AntDomNamedElement child : getFiles()) {
      final String fileName = child.getName().getStringValue();
      if (fileName != null) {
        files.add(new File(root, fileName));
      }
    }
    return files;
  }
}