public class BuildLayout_Import_BehaviorDescriptor extends BuildLayout_Node_BehaviorDescriptor implements BuildExternalDependency_BehaviorDescriptor, BuildLayout_FileSet_BehaviorDescriptor {
  public BuildLayout_Import_BehaviorDescriptor() {
  }
  public void virtual_fetchDependencies_5908258303322131137(SNode thisNode, VisibleArtifacts artifacts, RequiredDependenciesBuilder builder) {
    BuildLayout_Import_Behavior.virtual_fetchDependencies_5908258303322131137(thisNode, artifacts, builder);
  }
  @Override
  public String getConceptFqName() {
    return "jetbrains.mps.build.structure.BuildLayout_Import";
  }
}