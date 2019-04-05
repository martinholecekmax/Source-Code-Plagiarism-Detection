public class AssociationClassDashedLinkPreferencePage extends AbstractPapyrusLinkPreferencePage {
	
	public AssociationClassDashedLinkPreferencePage() {
		super();
		setPreferenceKey(ModelEditPart.MODEL_ID + "_AssociationClassDashedLink");
	}
	
	@Override
	protected String getBundleId() {
		return UMLDiagramEditorPlugin.ID;
	}
	
	public static void initDefaults(IPreferenceStore store) {
	}
}