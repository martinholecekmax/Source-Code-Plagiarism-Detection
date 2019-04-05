public class GeoGebraFrame3D extends GeoGebraFrame {
	public static synchronized void main(CommandLineArguments args) {		
		GeoGebraFrame.init(args,new GeoGebraFrame3D());
	}
	protected Application createApplication(CommandLineArguments args, JFrame frame){	
		return new Application3D(args, frame, true);
	}
}