public interface SimulatorAPIInterface {
	public void initiateSimulator(Simulator simulator, SimulatorInputData inputData) throws Exception;
	public void computeContactMap(Simulator simulator) throws Exception;
	public void locateDeadRules(Simulator simulator) throws Exception;
	public void computeInfluenceMap(Simulator simulator) throws Exception;
	public void buildInjections(Simulator simulator) throws Exception;
	public void loadKappaFile(Simulator simulator, String kappaInputId) throws Exception;
	public void computeLocalViews(Simulator simulator) throws Exception;
	
	public void returnError(Simulator simulator, String message) throws Exception;
	public void returnError(Simulator simulator, Exception exception) throws Exception;
	public void compressRulesQuality(Simulator simulator) throws Exception;
	public void compressRulesQuantity(Simulator simulator) throws Exception;
	public void simulateByTime(Simulator simulator, double time) throws Exception;
	public void simulateByEvents(Simulator simulator, long events) throws Exception;
	public void initializeSolution(Simulator simulator) throws Exception;
	public void enumerateSpecies(Simulator simulator) throws Exception;
	public void computeStories(Simulator simulator) throws Exception;
	public void computeSubviews(Simulator simulator) throws Exception;
	public void outputToXML(Simulator simulator, String xmlDestinationPath) throws Exception;
}