public class ModelelementsXMLProcessor extends XMLProcessor {
	
	public ModelelementsXMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		ModelelementsPackage.eINSTANCE.eClass();
	}
	
	@Override
	protected Map<String, Resource.Factory> getRegistrations() {
		if(registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new ModelelementsResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new ModelelementsResourceFactoryImpl());
		}
		return registrations;
	}
}