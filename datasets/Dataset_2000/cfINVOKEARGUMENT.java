public class cfINVOKEARGUMENT extends cfTag implements Serializable {
	static final long serialVersionUID = 1;
	public String getEndMarker() {
		return null;
	}
	public java.util.Map getInfo() {
		return createInfo("remote", "For use within the CFINVOKE tag.  This tag allows you to associate a parameter with the remote web services call.");
	}
	public java.util.Map[] getAttInfo() {
		return new java.util.Map[] { 
				createAttInfo("NAME", "The name of the variable you wish to set in this web services argument", "", true),
				createAttInfo("VALUE", "The value of the variable you wish to set in this web services argument", "", true)
		};
	}
	protected void defaultParameters(String _tag) throws cfmBadFileException {
		parseTagHeader(_tag);
		if (!containsAttribute("NAME"))
			throw newBadFileException("Missing Attribute", "You must specify a NAME attribute for CFINVOKEARGUMENT");
		if (!containsAttribute("VALUE"))
			throw newBadFileException("Missing Attribute", "You must specify a VALUE attribute for CFINVOKEARGUMENT");
	}
	public cfTagReturnType render(cfSession _Session) throws cfmRunTimeException {
		Map<cfData, cfData[]> invokeArgs = (Map<cfData, cfData[]>) _Session.getDataBin(cfINVOKECommon.DATA_BIN_KEY);
		if (invokeArgs == null) {
			throw newRunTimeException("CFINVOKEARGUMENT must be nested within a CFINVOKE tag");
		}
		cfBooleanData omitted = ((containsAttribute("OMIT") && getDynamic(_Session, "OMIT").getBoolean()) ? cfBooleanData.TRUE : cfBooleanData.FALSE);
		invokeArgs.put(getDynamic(_Session, "NAME"), new cfData[] { getDynamic(_Session, "VALUE"), omitted });
		return cfTagReturnType.NORMAL;
	}
}