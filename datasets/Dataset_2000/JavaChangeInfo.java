public interface JavaChangeInfo extends ChangeInfo {
  boolean isVisibilityChanged();
  boolean isExceptionSetChanged();
  boolean isExceptionSetOrOrderChanged();
  PsiMethod getMethod();
  CanonicalTypes.Type getNewReturnType();
  @NotNull
  JavaParameterInfo[] getNewParameters();
  @PsiModifier.ModifierConstant
  String getNewVisibility();
  @NotNull
  String[] getOldParameterNames();
  @NotNull
  String[] getOldParameterTypes();
  ThrownExceptionInfo[] getNewExceptions();
  boolean isRetainsVarargs();
  boolean isObtainsVarags();
  boolean isArrayToVarargs();
  PsiIdentifier getNewNameIdentifier();
  String getOldName();
  boolean wasVararg();
  boolean[] toRemoveParm();
  PsiExpression getValue(int i, PsiCallExpression callExpression);
  void updateMethod(PsiMethod psiMethod);
  Collection<PsiMethod> getMethodsToPropagateParameters();
}