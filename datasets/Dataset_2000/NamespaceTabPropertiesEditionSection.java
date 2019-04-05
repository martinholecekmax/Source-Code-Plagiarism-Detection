public class NamespaceTabPropertiesEditionSection implements IFilter {
	public boolean select(Object toTest) {
		EObject eObj = EEFUtils.resolveSemanticObject(toTest);
		return (eObj != null && eObj instanceof Namespace);
	}
}