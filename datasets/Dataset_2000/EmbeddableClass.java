public class EmbeddableClass extends ConfiguredClass {
	private final String embeddedAttributeName;
	private final String parentReferencingAttributeName;
	public EmbeddableClass(
			ClassInfo classInfo,
			String embeddedAttributeName,
			ConfiguredClass parent,
			AccessType defaultAccessType,
			AnnotationBindingContext context) {
		super( classInfo, defaultAccessType, parent, context );
		this.embeddedAttributeName = embeddedAttributeName;
		this.parentReferencingAttributeName = checkParentAnnotation();
	}
	private String checkParentAnnotation() {
		AnnotationInstance parentAnnotation = JandexHelper.getSingleAnnotation(
				getClassInfo(),
				HibernateDotNames.PARENT
		);
		if ( parentAnnotation == null ) {
			return null;
		}
		else {
			return JandexHelper.getPropertyName( parentAnnotation.target() );
		}
	}
	public String getEmbeddedAttributeName() {
		return embeddedAttributeName;
	}
	public String getParentReferencingAttributeName() {
		return parentReferencingAttributeName;
	}
}