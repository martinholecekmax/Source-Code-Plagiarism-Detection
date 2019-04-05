public class SpaceGraphVisualizationProvider implements ISpaceVisualizationProvider {
	public String getName() {
		return "Graph";
	}
	public ISpaceVisualization create(ISpace space) {
		return new SpaceGraphVisualization(space);
	}
}