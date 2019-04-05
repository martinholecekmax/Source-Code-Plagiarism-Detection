public class ModifiedDebugOptions {
	
	public ModifiedDebugOptions() {
		debugOptionsToAdd = new ArrayList<TracingComponentDebugOption>();
		debugOptionsToRemove = new ArrayList<TracingComponentDebugOption>();
	}
	
	public final TracingComponentDebugOption[] getDebugOptionsToAdd() {
		return debugOptionsToAdd.toArray(new TracingComponentDebugOption[debugOptionsToAdd.size()]);
	}
	
	public final TracingComponentDebugOption[] getDebugOptionsToRemove() {
		return debugOptionsToRemove.toArray(new TracingComponentDebugOption[debugOptionsToRemove.size()]);
	}
	
	public final void addDebugOption(final TracingComponentDebugOption option) {
		if (option != null) {
			boolean isBeingRemoved = debugOptionsToRemove.contains(option);
			if (isBeingRemoved) {
								debugOptionsToRemove.remove(option);
			}
						debugOptionsToAdd.add(option);
		}
	}
	
	public final void removeDebugOption(final TracingComponentDebugOption option) {
		if (option != null) {
			boolean isBeingAdded = debugOptionsToAdd.contains(option);
			if (isBeingAdded) {
								debugOptionsToAdd.remove(option);
			}
						debugOptionsToRemove.add(option);
		}
	}
	
	public final void clear() {
		debugOptionsToAdd.clear();
		debugOptionsToRemove.clear();
	}
	
	private List<TracingComponentDebugOption> debugOptionsToAdd = null;
	
	private List<TracingComponentDebugOption> debugOptionsToRemove = null;
}