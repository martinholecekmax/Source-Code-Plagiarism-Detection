public class ConnectableElementTemplateParameterPreferencePage extends AbstractPapyrusNodePreferencePage {
	
	public ConnectableElementTemplateParameterPreferencePage() {
		super();
		setPreferenceKey(ModelEditPart.MODEL_ID + "_ConnectableElementTemplateParameter");
	}
	
	@Override
	protected String getBundleId() {
		return UMLDiagramEditorPlugin.ID;
	}
	
	public static void initDefaults(IPreferenceStore store) {
		String key = ModelEditPart.MODEL_ID + "_ConnectableElementTemplateParameter";
		store.setDefault(PreferenceConstantHelper.getElementConstant(key, PreferenceConstantHelper.WIDTH), 40);
		store.setDefault(PreferenceConstantHelper.getElementConstant(key, PreferenceConstantHelper.HEIGHT), 40);
																	}
}