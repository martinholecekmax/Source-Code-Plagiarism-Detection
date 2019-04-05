public class MatrixParameterInjector implements ParameterInjector<MatrixParam> {
	@Override
	public <T> T getValue(WebRequest request, Map<String, String> pathParam,
			Providers providers, Type parameterType, MatrixParam annotation,
			boolean encodingDisabled, String defaultValue)
			throws UnsupportedFieldType {
		MultivaluedMap<String, String> matrix;		
		try {
			matrix = QueryStringParser.getMatrix(request.getWrhapiRequest().
					getRequestURI().getQuery(), encodingDisabled);
		} catch (HandlerException ex) {
			throw new RuntimeException(ex);
		}
		List<String> values = null;
		if (matrix != null) {
			values = matrix.get(annotation.value());
		} 
		if (values == null && defaultValue != null) {
			values = Collections.singletonList(defaultValue);
		} 
		return (T) ConversionUtil.convert(values, parameterType);
	}
}