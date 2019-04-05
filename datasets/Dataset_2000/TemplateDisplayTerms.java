public class TemplateDisplayTerms extends DisplayTerms {
	public static final String DESCRIPTION = "description";
	public static final String GROUP_ID = "groupId";
	public static final String NAME = "name";
	public static final String STRUCTURE_ID = "structureId";
	public static final String TEMPLATE_ID = "searchTemplateId";
	public TemplateDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);
		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);
		description = ParamUtil.getString(portletRequest, DESCRIPTION);
		groupId = ParamUtil.getLong(
			portletRequest, GROUP_ID, themeDisplay.getScopeGroupId());
		name = ParamUtil.getString(portletRequest, NAME);
		structureId = ParamUtil.getString(portletRequest, STRUCTURE_ID);
		templateId = ParamUtil.getString(portletRequest, TEMPLATE_ID);
	}
	public String getDescription() {
		return description;
	}
	public long getGroupId() {
		return groupId;
	}
	public String getName() {
		return name;
	}
	public String getStructureId() {
		return structureId;
	}
	public String getTemplateId() {
		return templateId;
	}
	protected String description;
	protected long groupId;
	protected String name;
	protected String structureId;
	protected String templateId;
}