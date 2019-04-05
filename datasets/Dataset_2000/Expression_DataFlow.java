public class Expression_DataFlow extends DataFlowBuilder {
  public Expression_DataFlow() {
  }
  public void build(final IOperationContext operationContext, final DataFlowBuilderContext _context) {
    _context.getBuilder().emitNop();
  }
}