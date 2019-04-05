@CamelContextInjectable
public class SampleClassResolver implements ClassResolver {
	
	@Override
	public InputStream loadResourceAsStream(final String uri) {
		return null;
	}
	
	@Override
	public URL loadResourceAsURL(final String uri) {
		return null;
	}
	
	@Override
	public Class<?> resolveClass(final String name) {
		return null;
	}
	
	@Override
	public <T> Class<T> resolveClass(final String name, final Class<T> type) {
		return null;
	}
	
	@Override
	public Class<?> resolveClass(final String name, final ClassLoader loader) {
		return null;
	}
	
	@Override
	public <T> Class<T> resolveClass(final String name, final Class<T> type,
	        final ClassLoader loader) {
		return null;
	}
	
	@Override
	public Class<?> resolveMandatoryClass(final String name)
	        throws ClassNotFoundException {
		return null;
	}
	
	@Override
	public <T> Class<T> resolveMandatoryClass(final String name,
	        final Class<T> type) throws ClassNotFoundException {
		return null;
	}
	
	@Override
	public Class<?> resolveMandatoryClass(final String name,
	        final ClassLoader loader) throws ClassNotFoundException {
		return null;
	}
	
	@Override
	public <T> Class<T> resolveMandatoryClass(final String name,
	        final Class<T> type, final ClassLoader loader)
	        throws ClassNotFoundException {
		return null;
	}
}