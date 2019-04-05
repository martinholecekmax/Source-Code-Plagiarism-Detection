public class ClassFileViewProviderFactory implements FileViewProviderFactory{
  @Override
  public FileViewProvider createFileViewProvider(@NotNull final VirtualFile file, final Language language, @NotNull final PsiManager manager, final boolean physical) {
        final ContentBasedFileSubstitutor[] processors = Extensions.getExtensions(ContentBasedFileSubstitutor.EP_NAME);
    for (ContentBasedFileSubstitutor processor : processors) {
      Language lang = processor.obtainLanguageForFile(file);
      if (lang != null) {
        FileViewProviderFactory factory = LanguageFileViewProviders.INSTANCE.forLanguage(language);
        return factory.createFileViewProvider(file, language, manager, physical);
      }
    }
    return new ClassFileViewProvider(manager, file, physical);
  }
}