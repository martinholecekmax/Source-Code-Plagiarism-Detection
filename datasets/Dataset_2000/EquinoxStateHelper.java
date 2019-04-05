public class EquinoxStateHelper {
	static final Worker equinoxSupport;
	static {
		Worker result = null;
		try {
			Class.forName("org.eclipse.osgi.service.resolver.BundleDescription"); 			result = new Worker();
		} catch (ClassNotFoundException e) {
					}
		equinoxSupport = result;
	}
	static final class Worker {
		final Long getBundleId(BundleRevision revision) {
			if (revision instanceof BundleDescription) {
				return ((BundleDescription) revision).getBundleId();
			}
			return null;
		}
		public long getStateTimeStamp(BundleContext context) {
			ServiceReference<PlatformAdmin> ref = context.getServiceReference(PlatformAdmin.class);
			if (ref == null)
				return -1;
			PlatformAdmin pa = context.getService(ref);
			if (pa == null)
				return -1;
			try {
				return pa.getState(false).getTimeStamp();
			} finally {
				context.ungetService(ref);
			}
		}
	}
	public static final long getBundleId(BundleRevision revision) {
				Bundle bundle = revision.getBundle();
		if (bundle != null) {
			return bundle.getBundleId();
		}
		Long result = equinoxSupport == null ? null : equinoxSupport.getBundleId(revision);
		if (result == null)
			throw new RuntimeException(String.format("Cannot determine bundle id of BundleRevision '%s'", revision)); 		return result;
	}
	public static final long getStateTimeStamp(BundleContext context) {
		return equinoxSupport == null ? -1 : equinoxSupport.getStateTimeStamp(context);
	}
}