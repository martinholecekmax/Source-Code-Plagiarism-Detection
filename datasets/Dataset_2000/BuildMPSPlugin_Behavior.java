public class BuildMPSPlugin_Behavior {
  public static void init(SNode thisNode) {
  }
  public static Scope virtual_getLayoutScope_1224588814561807654(SNode thisNode, SNode kind) {
    if (SConceptOperations.isSubConceptOf(kind, "jetbrains.mps.build.mps.structure.BuildMps_AbstractModule") || SConceptOperations.isSubConceptOf(kind, "jetbrains.mps.build.mps.structure.BuildMps_Group") || SConceptOperations.isSubConceptOf(kind, "jetbrains.mps.build.mps.structure.BuildMps_IdeaPlugin")) {
      return DescendantsScope.forNamedElements(BuildPlugin_Behavior.call_getProject_1224588814561866657(thisNode), SLinkOperations.findLinkDeclaration("jetbrains.mps.build.structure.BuildProject", "parts"), kind);
    }
    return null;
  }
  public static Scope virtual_getProjectStructureScope_3734116213129936182(SNode thisNode, final SNode kind) {
    if (SConceptOperations.isSubConceptOf(kind, "jetbrains.mps.build.mps.structure.BuildMps_AbstractModule") || SConceptOperations.isSubConceptOf(kind, "jetbrains.mps.build.mps.structure.BuildMps_IdeaPlugin") || SConceptOperations.isSubConceptOf(kind, "jetbrains.mps.build.mps.structure.BuildMps_Group")) {
      return new CompositeScope(Sequence.fromIterable(BuildProject_Behavior.call_getVisibleProjects_1224588814561807665(BuildPlugin_Behavior.call_getProject_1224588814561866657(thisNode), false)).select(new ISelector<SNode, DescendantsScope>() {
        public DescendantsScope select(SNode it) {
          return DescendantsScope.forNamedElements(it, SLinkOperations.findLinkDeclaration("jetbrains.mps.build.structure.BuildProject", "parts"), kind);
        }
      }).concat(Sequence.fromIterable(Sequence.<DescendantsScope>singleton(DescendantsScope.forNamedElements(BuildPlugin_Behavior.call_getProject_1224588814561866657(thisNode), SLinkOperations.findLinkDeclaration("jetbrains.mps.build.structure.BuildProject", "parts"), kind)))).toGenericArray(DescendantsScope.class));
    }
    return null;
  }
}