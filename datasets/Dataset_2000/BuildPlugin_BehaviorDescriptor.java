public abstract class BuildPlugin_BehaviorDescriptor extends BaseConcept_BehaviorDescriptor {
  public BuildPlugin_BehaviorDescriptor() {
  }
  public Scope virtual_getLayoutScope_1224588814561807654(SNode thisNode, SNode kind) {
    return BuildPlugin_Behavior.virtual_getLayoutScope_1224588814561807654(thisNode, kind);
  }
  public Scope virtual_getProjectStructureScope_3734116213129936182(SNode thisNode, SNode kind) {
    return BuildPlugin_Behavior.virtual_getProjectStructureScope_3734116213129936182(thisNode, kind);
  }
  @Override
  public String getConceptFqName() {
    return "jetbrains.mps.build.structure.BuildPlugin";
  }
}