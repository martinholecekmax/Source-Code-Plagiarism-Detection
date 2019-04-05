public class RuntimeGenModelAccess extends BasicGenModelAccess {
	private GenPackage genPackage;
	public RuntimeGenModelAccess() {
		super(NotationPackage.eINSTANCE);
		registerLocation(fromExtpoint());
	}
	
	public GenPackage genPackage() {
		if (genPackage == null) {
							genPackage = model().findGenPackage(NotationPackage.eINSTANCE);
		}
		return genPackage;
	}
}