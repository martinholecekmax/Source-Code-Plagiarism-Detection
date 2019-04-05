public class EntityProgressLogger implements SinkSource {
	private static final Logger LOG = Logger.getLogger(EntityProgressLogger.class.getName());
	private Sink sink;
	private ProgressTracker progressTracker;
	private String prefix;
	
	public EntityProgressLogger(int interval, String label) {
		progressTracker = new ProgressTracker(interval);
		if (label != null && !label.equals("")) {
			prefix = "[" + label + "] ";
		} else {
			prefix = "";
		}
	}
	
	public void initialize(Map<String, Object> metaData) {
		progressTracker.initialize();
		sink.initialize(metaData);
	}
	
	public void process(EntityContainer entityContainer) {
		Entity entity;
		entity = entityContainer.getEntity();
		if (progressTracker.updateRequired()) {
			LOG.info(
					prefix
					+ "Processing " + entity.getType() + " " + entity.getId() + ", "
					+ progressTracker.getObjectsPerSecond() + " objects/second.");
		}
		sink.process(entityContainer);
	}
	
	public void complete() {
		LOG.info("Processing completion steps.");
		long start = System.currentTimeMillis();
		sink.complete();
		long duration = System.currentTimeMillis() - start;
		LOG.info("Completion steps took " + duration / 1000d + " seconds.");
		LOG.info("Processing complete.");
	}
	
	public void release() {
		sink.release();
	}
	
	public void setSink(Sink sink) {
		this.sink = sink;
	}
}