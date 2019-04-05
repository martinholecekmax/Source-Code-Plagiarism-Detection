public class ProBCommandJob extends Job {
	private final Animator animator;
	private final IComposableCommand command;
	private boolean commandFailed = false;
	public ProBCommandJob(final String name, final Animator animator,
			final IComposableCommand command) {
		super(name);
		this.animator = animator;
		this.command = command;
	}
	@Override
	protected IStatus run(final IProgressMonitor monitor) {
		Activator.getDefault().registerJob(this);
		monitor.beginTask(getName(), IProgressMonitor.UNKNOWN);
		commandFailed = false;
		try {
			animator.execute(command);
		} catch (ProBException e) {
			commandFailed = true;
			e.notifyUserOnce();
			return Status.CANCEL_STATUS;
		}
		return Status.OK_STATUS;
	}
	@Override
	protected void canceling() {
		animator.sendUserInterruptSignal();
	}
	public IComposableCommand getCommand() {
		return command;
	}
	public Animator getAnimator() {
		return animator;
	}
	public boolean isCommandFailed() {
		return commandFailed;
	}
}