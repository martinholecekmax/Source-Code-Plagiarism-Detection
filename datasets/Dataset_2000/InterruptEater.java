public abstract class InterruptEater {
	public InterruptEater() throws Throwable {
		start();
	}
	private void start() throws Throwable {
		boolean interrupted;
		do {
			interrupted = false;
			try {
				run();
			} catch (Throwable _e) {
								Throwable e = ExceptionUtil.getDeepestCause(_e);
				if (e instanceof InterruptedException) {
					interrupted = true;
					Thread.interrupted(); 				} else {
					throw _e;
				}
			}
		} while (interrupted);
	}
	protected abstract void run() throws Exception;
}