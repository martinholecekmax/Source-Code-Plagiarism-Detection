public class ComponentsList_BehaviorDescriptor extends AbstractProjectComponent_BehaviorDescriptor implements IAbstractCompositeComponent_BehaviorDescriptor, ITransparentProjectComponent_BehaviorDescriptor {
  public ComponentsList_BehaviorDescriptor() {
  }
  public List<SNode> virtual_getChildrenToDo_1240564451382(SNode thisNode) {
    return ComponentsList_Behavior.virtual_getChildrenToDo_1240564451382(thisNode);
  }
  public String virtual_getChildrenTargetDir_1237389224202(SNode thisNode) {
    return ComponentsList_Behavior.virtual_getChildrenTargetDir_1237389224202(thisNode);
  }
  @Override
  public String getConceptFqName() {
    return "jetbrains.mps.build.packaging.structure.ComponentsList";
  }
}