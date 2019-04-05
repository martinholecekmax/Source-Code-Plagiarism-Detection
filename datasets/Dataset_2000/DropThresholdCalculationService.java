public class DropThresholdCalculationService extends Service implements
		Serializable {
	
	public DropThresholdCalculationService() {
	};
	
	private long	smoothingWeight;
	
	public long getSmoothingWeight() {
		return this.smoothingWeight;
	} 	
	public void setSmoothingWeight(long smoothingWeight) {
		this.smoothingWeight = smoothingWeight;
	} 	
	private long	timeInterval;
	
	public long getTimeInterval() {
		return this.timeInterval;
	} 	
	public void setTimeInterval(long timeInterval) {
		this.timeInterval = timeInterval;
	} }