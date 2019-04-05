public class PackageWithTooManyClassesInspection extends BaseGlobalInspection {
  @SuppressWarnings({"PublicField"})
  public int limit = 10;
  @NotNull
  @Override
  public String getDisplayName() {
    return InspectionGadgetsBundle.message(
      "package.with.too.many.classes.display.name");
  }
  @Override
  @Nullable
  public CommonProblemDescriptor[] checkElement(
    RefEntity refEntity,
    AnalysisScope analysisScope,
    InspectionManager inspectionManager,
    GlobalInspectionContext globalInspectionContext) {
    if (!(refEntity instanceof RefPackage)) {
      return null;
    }
    final List<RefEntity> children = refEntity.getChildren();
    if (children == null) {
      return null;
    }
    int numClasses = 0;
    for (RefEntity child : children) {
      if (child instanceof RefClass) {
        numClasses++;
      }
    }
    if (numClasses <= limit) {
      return null;
    }
    final String errorString = InspectionGadgetsBundle.message(
      "package.with.too.many.classes.problem.descriptor",
      refEntity.getQualifiedName(), Integer.valueOf(numClasses),
      Integer.valueOf(limit));
    return new CommonProblemDescriptor[]{
      inspectionManager.createProblemDescriptor(errorString)
    };
  }
  @Override
  public JComponent createOptionsPanel() {
    return new SingleIntegerFieldOptionsPanel(
      InspectionGadgetsBundle.message(
        "package.with.too.many.classes.max.option"),
      this, "limit");
  }
}