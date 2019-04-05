public class CorePreferencePage
	extends FieldEditorPreferencePage
	implements IWorkbenchPreferencePage {
	
	public CorePreferencePage() {
		super(GRID);
		setPreferenceStore(CertWareUI.getDefault().getPreferenceStore());
		setDescription("CertWare Core Preferences");
		setImageDescriptor(CertWareUI.getDefault().getImageRegistry().getDescriptor(CertWareUI.PREFERENCES_IMAGE));
	}
	
	public void createFieldEditors() {
		
		addField( 
				new StringFieldEditor(PreferenceConstants.P_PROJECT_NAME,
						"Project &name:",
						getFieldEditorParent()));
		addField( 
				new StringFieldEditor(PreferenceConstants.P_LABEL_DECORATOR_SUFFIX,
						"&Resource decorator suffix:",
						getFieldEditorParent()));
		addField(
		        new ColorFieldEditor(PreferenceConstants.P_LABEL_DECORATOR_FOREGROUND,
		          "Resource decorator &foreground:",
		          getFieldEditorParent()));
	}
	
	public void init(IWorkbench workbench) {
	}
}