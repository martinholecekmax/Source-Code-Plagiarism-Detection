public class InsideSubRoutineFlowContext extends FlowContext {
	public UnconditionalFlowInfo initsOnReturn;
public InsideSubRoutineFlowContext(
	FlowContext parent,
	ASTNode associatedNode) {
	super(parent, associatedNode);
	this.initsOnReturn = FlowInfo.DEAD_END;
}
public String individualToString() {
	StringBuffer buffer = new StringBuffer("Inside SubRoutine flow context"); 	buffer.append("[initsOnReturn -").append(this.initsOnReturn.toString()).append(']'); 	return buffer.toString();
}
public UnconditionalFlowInfo initsOnReturn(){
	return this.initsOnReturn;
}
public boolean isNonReturningContext() {
	return ((SubRoutineStatement) this.associatedNode).isSubRoutineEscaping();
}
public void recordReturnFrom(UnconditionalFlowInfo flowInfo) {
	if ((flowInfo.tagBits & FlowInfo.UNREACHABLE) == 0)	{
	if (this.initsOnReturn == FlowInfo.DEAD_END) {
		this.initsOnReturn = (UnconditionalFlowInfo) flowInfo.copy();
	} else {
		this.initsOnReturn = this.initsOnReturn.mergedWith(flowInfo);
	}
	}
}
public SubRoutineStatement subroutine() {
	return (SubRoutineStatement) this.associatedNode;
}
}