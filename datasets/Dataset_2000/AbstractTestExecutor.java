public abstract class AbstractTestExecutor implements TestExecutor {
	protected final CliExecutor cli;
	public AbstractTestExecutor(final Log log) {
		cli = new CliExecutor(log);
		cli.setStdOutConsumer(new StreamConsumer() {
			@Override
			public void consumeLine(String line) {
				log.info(line);
			}
		});
		cli.setStdErrConsumer(new StreamConsumer() {
			@Override
			public void consumeLine(String line) {
				log.info(line);
			}
		});
	}
}