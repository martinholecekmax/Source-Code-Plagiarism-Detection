public class check_AbstractSubtypingRule_NonTypesystemRule extends AbstractNonTypesystemRule_Runtime implements NonTypesystemRule_Runtime {
  public check_AbstractSubtypingRule_NonTypesystemRule() {
  }
  public void applyRule(final SNode abstractSubtypingRule, final TypeCheckingContext typeCheckingContext, IsApplicableStatus status) {
    DataFlowUtil.checkDataFlow(typeCheckingContext, SLinkOperations.getTarget(abstractSubtypingRule, "body", true));
  }
  public String getApplicableConceptFQName() {
    return "jetbrains.mps.lang.typesystem.structure.AbstractSubtypingRule";
  }
  public IsApplicableStatus isApplicableAndPattern(SNode argument) {
    {
      boolean b = SModelUtil_new.isAssignableConcept(argument.getConcept().getId(), this.getApplicableConceptFQName());
      return new IsApplicableStatus(b, null);
    }
  }
  public boolean overrides() {
    return false;
  }
}