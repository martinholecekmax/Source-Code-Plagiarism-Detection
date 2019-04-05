public class DetectorFactory {
	private static DetectorFactory instance = new DetectorFactory();
	private DetectorFactory(){
	}
	public static DetectorFactory getInstance(){
		return instance;
	}
	public Detector buildDetector(){
		return new Detector(){
			private Detector typeDetector = new TypeDetector();
			private Detector defaultDetector = new DefaultDetector();
			@Override
			public MediaType detect(InputStream input, Metadata metadata)
					throws IOException {
				MediaType type = typeDetector.detect(input, metadata);
				if (MediaType.OCTET_STREAM == type){
					type = defaultDetector.detect(input, metadata);
				}
				return type;
			}
		};
	}
	public static void main(String[] args) throws Exception{
		DetectorFactory detector = DetectorFactory.getInstance();
	}
}