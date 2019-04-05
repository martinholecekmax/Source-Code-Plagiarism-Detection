public class CopyAllNonConflictingCommand extends ChangeCommand {
	
	private final List<? extends Diff> differences;
	
	private final boolean leftToRight;
	
	public CopyAllNonConflictingCommand(ChangeRecorder changeRecorder, Collection<Notifier> notifiers,
			List<? extends Diff> differences, boolean leftToRight) {
		super(changeRecorder, notifiers);
		this.differences = differences;
		this.leftToRight = leftToRight;
	}
	
	@Override
	public boolean canExecute() {
		return super.canExecute() && Iterables.any(differences, hasState(DifferenceState.UNRESOLVED));
	}
	
	@Override
	protected void doExecute() {
		if (leftToRight) {
			for (Diff diff : differences) {
				if (diff.getSource() == DifferenceSource.LEFT && diff.getConflict() == null) {
					diff.copyLeftToRight();
				}
			}
		} else {
			for (Diff diff : differences) {
				if (diff.getSource() == DifferenceSource.RIGHT && diff.getConflict() == null) {
					diff.copyRightToLeft();
				}
			}
		}
	}
}