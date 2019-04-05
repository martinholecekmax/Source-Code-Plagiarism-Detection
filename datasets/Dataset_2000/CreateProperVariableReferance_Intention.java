public class CreateProperVariableReferance_Intention extends BaseIntention implements Intention {
  public CreateProperVariableReferance_Intention() {
  }
  public String getConcept() {
    return "jetbrains.mps.bash.structure.VariableReference";
  }
  public boolean isParameterized() {
    return false;
  }
  public boolean isErrorIntention() {
    return false;
  }
  public boolean isAvailableInChildNodes() {
    return false;
  }
  public String getDescription(final SNode node, final EditorContext editorContext) {
    return "Create Proper Variable Reference";
  }
  public void execute(final SNode node, final EditorContext editorContext) {
    SNode expansion = SNodeFactoryOperations.createNewNode("jetbrains.mps.bash.structure.BasicParameterExpansion", null);
    SNodeOperations.replaceWithAnother(node, expansion);
    SLinkOperations.setTarget(expansion, "variable", SLinkOperations.getTarget(node, "variable", false), false);
    editorContext.select(expansion);
  }
  public String getLocationString() {
    return "jetbrains.mps.bash.intentions";
  }
}