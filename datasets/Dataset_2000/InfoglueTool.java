public class InfoglueTool
{
	private String toolName  	    = "";
	private String actionURL  	    = "";
	private String imageURL         = "";
	private String cssClass         = "";
	private String title            = "";
	private String tooltip 			= "";
	private String target 			= null;
	public InfoglueTool(String toolName, String actionURL, String imageURL, String title, String tooltip, String cssClass, String target)
	{
		this.toolName   = toolName;
		this.tooltip	= tooltip;
		this.actionURL  = actionURL;
		this.imageURL   = imageURL;
		this.title      = title;
		this.cssClass   = cssClass;
		this.target		= target;
	}
	public String getToolName()
	{
		return this.toolName;
	}
	public String getActionUrl()
	{
		return this.actionURL;
	}
	public String getImageUrl()
	{
		return this.imageURL;
	}
	public String getTitle()
	{
		return this.title;
	}
	public String getTooltip() 
	{
		return tooltip;
	}
	public String getCssClass() 
	{
		return cssClass;
	}
	public String getTarget() 
	{
		return target;
	}
}