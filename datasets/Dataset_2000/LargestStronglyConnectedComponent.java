public class LargestStronglyConnectedComponent extends
		LargestConnectedComponent {
	public LargestStronglyConnectedComponent() {
		super("LARGEST_STRONGLY_CONNECTED_COMPONENT");
	}
	@Override
	protected int[] getLargestComponent(Graph g) {
		StrongConnectivityPartition t = new StrongConnectivityPartition();
		Partition p = t.getStrongPartition(g);
		return p.getLargestComponent();
	}
}