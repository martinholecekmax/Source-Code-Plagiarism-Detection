public class BuildSource_SingleFolder_Behavior {
  private static Class[] PARAMETERS_5610619299014531547 = {SNode.class};
  public static void init(SNode thisNode) {
  }
  public static String call_getApproximateName_5610619299014531547(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (String) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.structure.BuildSource_SingleFolder"), "virtual_getApproximateName_5610619299014531547", PARAMETERS_5610619299014531547, new Object[]{});
  }
  public static String callSuperNew_getApproximateName_5610619299014531547(SNode thisNode, String callerConceptFqName) {
    return (String) BehaviorManager.getInstance().invokeSuperNew(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.structure.BuildSource_SingleFolder"), callerConceptFqName, "virtual_getApproximateName_5610619299014531547", PARAMETERS_5610619299014531547, new Object[]{});
  }
  @Deprecated
  public static String callSuper_getApproximateName_5610619299014531547(SNode thisNode, String callerConceptFqName) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.structure.BuildSource_SingleFolder"), callerConceptFqName, "virtual_getApproximateName_5610619299014531547", PARAMETERS_5610619299014531547, new Object[]{});
  }
}