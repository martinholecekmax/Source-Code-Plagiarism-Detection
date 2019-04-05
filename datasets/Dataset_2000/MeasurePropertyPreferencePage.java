public class MeasurePropertyPreferencePage extends AbstractPapyrusNodePreferencePage{
	
	public MeasurePropertyPreferencePage(){
		super();
		setPreferenceKey(CubeQueryEditPart.MODEL_ID + "_MeasureProperty");
	}
	
	@Override
	protected String getBundleId(){
		return UimCubeQueryDiagramEditorPlugin.ID;
	}
	
	public static void initDefaults(IPreferenceStore store){
		String key = CubeQueryEditPart.MODEL_ID + "_MeasureProperty";
		store.setDefault(PreferenceConstantHelper.getElementConstant(key, PreferenceConstantHelper.WIDTH), 40);
		store.setDefault(PreferenceConstantHelper.getElementConstant(key, PreferenceConstantHelper.HEIGHT), 40);
																	}
}