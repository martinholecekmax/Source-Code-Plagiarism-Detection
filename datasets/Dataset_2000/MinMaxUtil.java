public final class MinMaxUtil {
	
	private MinMaxUtil() { }
	
	public static final <T> T min(Iterable<T> objects, Function<T, Double> f) {
		T currentMinObject = null;
		Double currentMinValue = null;
		for (T object : objects) {
			if (currentMinObject == null
					|| f.apply(object) < currentMinValue) {
				currentMinObject = object;
				currentMinValue = f.apply(object);
			}
		}
		return currentMinObject;
	}
	
	public static final <T> T max(Iterable<T> objects, Function<T, Double> f) {
		T currentMaxObject = null;
		Double currentMaxValue = null;
		for (T object : objects) {
			if (currentMaxObject == null
					|| f.apply(object) > currentMaxValue) {
				currentMaxObject = object;
				currentMaxValue = f.apply(object);
			}
		}
		return currentMaxObject;
	}
}