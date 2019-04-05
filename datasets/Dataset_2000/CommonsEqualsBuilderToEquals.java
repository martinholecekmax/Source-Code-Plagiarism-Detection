public class CommonsEqualsBuilderToEquals extends BytecodeScanningDetector {
	private final OpcodeStack stack;
	private final BugReporter bugReporter;
	
	public CommonsEqualsBuilderToEquals(final BugReporter bugReporter) {
		stack = new OpcodeStack();
		this.bugReporter = bugReporter;
	}
	
	@Override
	public void visitCode(Code obj) {
		stack.resetForMethodEntry(this);
		LocalVariableTable lvt = getMethod().getLocalVariableTable();
		if (lvt != null) {
			super.visitCode(obj);
		}
	}
	@Override
	public void sawOpcode(int seen) {
		try {
			switch (seen) {
			case INVOKEVIRTUAL:
				String methodName = getNameConstantOperand();
				if ("equals".equals(methodName)
						&& "(Ljava/lang/Object;)Z"
								.equals(getSigConstantOperand())) {
					String calledClass = stack.getStackItem(1).getSignature();
					if ("Lorg/apache/commons/lang3/builder/EqualsBuilder;"
							.equals(calledClass)
							|| "org/apache/commons/lang/builder/EqualsBuilder"
									.equals(calledClass)) {
						bugReporter.reportBug(new BugInstance(this,
								"CEBE_COMMONS_EQUALS_BUILDER_ISEQUALS",
								HIGH_PRIORITY).addClass(this).addMethod(this)
								.addSourceLine(this));
					}
				}
			}
		} finally {
			super.sawOpcode(seen);
			stack.sawOpcode(this, seen);
		}
	}
}