public abstract class ExternalAnnotator<InitialInfoType, AnnotationResultType> {
    @Nullable
  public InitialInfoType collectionInformation(@NotNull PsiFile file) {
    return null;
  }
    @Nullable
  public AnnotationResultType doAnnotate(InitialInfoType collectedInfo) {
    return null;
  }
    public void apply(@NotNull PsiFile file, AnnotationResultType annotationResult, @NotNull AnnotationHolder holder) {
  }
  
    @Deprecated
  public void annotate(PsiFile file, AnnotationHolder holder) {
  }
}