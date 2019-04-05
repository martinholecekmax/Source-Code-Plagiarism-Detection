public class StartProcessHandlerStatement_DataFlow extends DataFlowBuilder {
  public StartProcessHandlerStatement_DataFlow() {
  }
  public void build(final IOperationContext operationContext, final DataFlowBuilderContext _context) {
    _context.getBuilder().build((SNode) SLinkOperations.getTarget(_context.getNode(), "expression", true));
    _context.getBuilder().build((SNode) SLinkOperations.getTarget(_context.getNode(), "tool", true));
    _context.getBuilder().emitRet();
  }
}