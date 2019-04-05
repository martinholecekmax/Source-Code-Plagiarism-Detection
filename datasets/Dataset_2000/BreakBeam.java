public class BreakBeam implements IBooleanSensor {
	private cbccore.low.Sensor lowSensor = Device.getLowSensorController();
	private int port = 0;
	public BreakBeam(int port) throws InvalidPortException {
		if(port < 0 || port > 7) { throw new InvalidPortException(); }
		this.port = port;
	}
	public boolean getValue() {
		return lowSensor.digital(port) != 0;
	}
}