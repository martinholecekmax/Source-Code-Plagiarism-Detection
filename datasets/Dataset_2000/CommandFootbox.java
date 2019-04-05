public class CommandFootbox extends SingleLineCommand<SequenceDiagram> {
	public CommandFootbox(SequenceDiagram sequenceDiagram) {
		super(sequenceDiagram, "(?i)^(hide|show)?\\s*footbox?$");
	}
	@Override
	protected CommandExecutionResult executeArg(List<String> arg) {
		final boolean footbox = arg.get(0).equalsIgnoreCase("show");
		getSystem().setShowFootbox(footbox);
		return CommandExecutionResult.ok();
	}
}