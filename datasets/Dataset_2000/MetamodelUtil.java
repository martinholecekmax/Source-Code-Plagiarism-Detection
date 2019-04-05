public class MetamodelUtil {
	public EClass getEcoreClass(GenClass clazz) {
		return clazz.getEcoreClass();
	}
	public EEnum getEcoreEnum(GenEnum enumeration) {
		return enumeration.getEcoreEnum();
	}
	public EPackage getEcorePackage(GenPackage packaje) {
		return packaje.getEcorePackage();
	}
}