public abstract class AbstractValidateDocUpdate {
	public static class UserCtx extends BaseModel {
		private List<String> m_roles = null;
		UserCtx(JSOModel pModel) {
			super(pModel);
		}
		public String getDB() {
			return get("db");
		}
		public String getUserName() {
			return get("name");
		}
		public List<String> getRoles() {
			if (m_roles == null) {
				m_roles = getStringList("roles");
			}
			return m_roles;
		}
	}
	public AbstractValidateDocUpdate() {
		jsExport();
	}
	private final native void jsExport() ;
	public final native void unauthorized(String pMessage) ;
	public final native void forbidden(String pMessage) ;
	public final void validateInternal(JavaScriptObject pNewDoc,JavaScriptObject pOldDoc,JavaScriptObject pUserCtx) {
		BaseDocument newDoc = new BaseDocument(JSOModel.fromJavascriptObject(pNewDoc));
		BaseDocument oldDoc = pOldDoc != null ? new BaseDocument(JSOModel.fromJavascriptObject(pOldDoc)) : null;
		UserCtx userCtx = new UserCtx(JSOModel.fromJavascriptObject(pUserCtx));
		validate(newDoc,oldDoc,userCtx);
	}
	public abstract void validate(BaseDocument pNewDoc,BaseDocument pOldDoc,UserCtx pUserCtx);
}