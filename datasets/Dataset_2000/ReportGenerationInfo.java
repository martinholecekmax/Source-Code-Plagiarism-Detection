public class ReportGenerationInfo implements Serializable
{		
	private static final long serialVersionUID = -5447404532659417568L;
	private String userName;
	private String reportName;
	private String reportDescription;
	private String reportFileName;
	private Date runDate;
	private Map parameters;		
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public Map getParameters()
	{
		return parameters;
	}
	public void setParameters(Map parameters)
	{
		this.parameters = parameters;
	}
	public String getParameterList()
	{
		if (parameters == null || parameters.size() < 1) return "";
		StringBuffer buffer = new StringBuffer();
		Iterator iterator = parameters.keySet().iterator();
		while (iterator.hasNext())
		{
			String key = (String) iterator.next();
			if (key.indexOf("OPENREPORTS_") == -1)
			{			
				buffer.append(key + "=" + parameters.get(key) + " ");
			}
		}
		return buffer.toString();
	}
	public String getReportDescription()
	{
		return reportDescription;
	}
	public void setReportDescription(String reportDescription)
	{
		this.reportDescription = reportDescription;
	}
	public String getReportName()
	{
		return reportName;
	}
	public void setReportName(String reportName)
	{
		this.reportName = reportName;
	}
	public Date getRunDate()
	{
		return runDate;
	}
	public void setRunDate(Date runDate)
	{
		this.runDate = runDate;
	}
	public String getReportFileName()
	{
		return reportFileName;
	}
	public void setReportFileName(String reportFileName)
	{
		this.reportFileName = reportFileName;
	}
}