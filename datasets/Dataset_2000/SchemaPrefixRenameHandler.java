public class SchemaPrefixRenameHandler extends VariableInplaceRenameHandler {
  @Override
  protected boolean isAvailable(PsiElement element, Editor editor, PsiFile file) {
    PossiblePrefixReference ref = getReference(file, editor);
    return ref != null && ref.resolve() instanceof SchemaPrefix;
  }
  @Nullable
  private static PossiblePrefixReference getReference(PsiFile file, Editor editor) {
    if (file != null && editor != null) {
      int offset = editor.getCaretModel().getOffset();
      PsiReference reference = file.findReferenceAt(offset);
      if (reference instanceof PossiblePrefixReference) {
        return (PossiblePrefixReference)reference;
      }
    }
    return null;
  }
  @Override
  protected VariableInplaceRenamer createRenamer(@NotNull PsiElement elementToRename, Editor editor) {
    PossiblePrefixReference reference = getReference(elementToRename.getContainingFile(), editor);
    if (reference != null) {
      PsiElement prefix = reference.resolve();
      if (prefix instanceof SchemaPrefix) {
        return new VariableInplaceRenamer((PsiNamedElement)prefix, editor) {
          @Override
          protected void addReferenceAtCaret(Collection<PsiReference> refs) {}
        };
      }
    }
    if (ApplicationManager.getApplication().isUnitTestMode()) {
      System.out.println("Reference: " + reference);
      if (reference != null) {
        System.out.println("Resolved: " + reference.resolve());
      }
    }
    return null;
  }
}