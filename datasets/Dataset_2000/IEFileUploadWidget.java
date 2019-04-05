public class IEFileUploadWidget extends IENonEditableTextWidget {
					
	public static final String FILE_UPLOAD_WIDGET = "file_upload_widget";
	public IEFileUploadWidget(FlexoComponentBuilder builder) {
		this(builder.woComponent, null, builder.getProject());
		initializeDeserialization(builder);
	}
	public IEFileUploadWidget(IEWOComponent woComponent, IEObject parent, FlexoProject prj) {
		super(woComponent, parent, prj);
	}
	@Override
	public String getDefaultInspectorName() {
		return "FileUpload.inspector";
	}
	
	@Override
	public Vector<IObject> getEmbeddedIEObjects() {
		return EMPTY_IOBJECT_VECTOR;
	}
	@Override
	public String getFullyQualifiedName() {
		return "FileUpload";
	}
	
	@Override
	public String getClassNameKey() {
		return FILE_UPLOAD_WIDGET;
	}
	@Override
	public boolean generateJavascriptID() {
		return true;
	}
}