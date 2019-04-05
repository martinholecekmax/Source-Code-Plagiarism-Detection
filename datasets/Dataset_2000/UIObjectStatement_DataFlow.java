public class UIObjectStatement_DataFlow extends DataFlowBuilder {
  public UIObjectStatement_DataFlow() {
  }
  public void build(final IOperationContext operationContext, final DataFlowBuilderContext _context) {
    for (SNode vb : ListSequence.fromList(SLinkOperations.getTargets(_context.getNode(), "viewBinding", true))) {
      _context.getBuilder().build((SNode) vb);
    }
    for (SNode cb : ListSequence.fromList(SLinkOperations.getTargets(_context.getNode(), "controllerBinding", true))) {
      _context.getBuilder().build((SNode) cb);
    }
    for (SNode cc : ListSequence.fromList(SLinkOperations.getTargets(_context.getNode(), "compartment", true))) {
      _context.getBuilder().build((SNode) cc);
    }
    for (SNode as : ListSequence.fromList(SLinkOperations.getTargets(_context.getNode(), "aspect", true))) {
      _context.getBuilder().build((SNode) as);
    }
    if (UIObjectStatement_Behavior.call_shouldReturnValue_7109250785404509292(_context.getNode())) {
      _context.getBuilder().emitRet();
    }
  }
}