public interface GoFile extends PsiFile, GoPsiElement, GoPackagedElement {
    GoFile[] EMPTY_ARRAY = new GoFile[0];
    String getPackageImportPath();
    GoPackageDeclaration getPackage();
    GoImportDeclarations[] getImportDeclarations();
    GoFunctionDeclaration[] getFunctions();
    GoMethodDeclaration[] getMethods();
    GoConstDeclarations[] getConsts();
    GoVarDeclarations[] getGlobalVariables();
    boolean isApplicationPart();
    GoFunctionDeclaration getMainFunction();
    GoTypeDeclaration[] getTypeDeclarations();
}