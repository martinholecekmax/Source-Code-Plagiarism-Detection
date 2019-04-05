public class RetrieveStoriesForIteration extends RetrieveStories {
	private static final Logger logger = Logger.getLogger(RetrieveStoriesForIteration.class);
	private String iterationName = null;
	
	@Override
	protected void showHelp(Options opts) {
		HelpFormatter formatter = new HelpFormatter();
		String myName = this.getClass().getCanonicalName();
		formatter.printHelp(myName+" [options] iteration-name", opts);
	}
	
	@Override
	protected boolean processOptions(CommandLine parsedCmdLine) throws Exception {
		if (!super.processOptions(parsedCmdLine)) {
			return false;
		}
		String[] remainingArgs = parsedCmdLine.getArgs();
		if (remainingArgs.length == 1) {
			this.iterationName = remainingArgs[0];
		} else {
			throw new MissingOptionException("a single iteration name is required");
		}
		return true;
	}
	
	@Override
	protected StoryList fetchStories(ServerConnection server) throws Exception {
		return server.retrieveStoriesForIteration(this.iterationName);
	}
	public static void main(String[] args) {
		try {
			RetrieveStories app = new RetrieveStoriesForIteration();
			app.run(args);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}