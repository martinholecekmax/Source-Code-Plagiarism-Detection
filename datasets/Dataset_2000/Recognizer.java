public abstract class Recognizer {
	public abstract void setRoutes(List<Route> routes);
	public abstract Options recognize(String path);
	public abstract boolean isOptimized();
	public abstract void optimize();
}