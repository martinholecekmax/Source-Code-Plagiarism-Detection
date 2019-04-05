public class WebDeployer extends BaseDeployer {
	public static void main(String[] args) {
		InitUtil.initWithSpring();
		List<String> wars = new ArrayList<String>();
		List<String> jars = new ArrayList<String>();
		for (String arg : args) {
			if (arg.endsWith(".war")) {
				wars.add(arg);
			}
			else if (arg.endsWith(".jar")) {
				jars.add(arg);
			}
		}
		new WebDeployer(wars, jars);
	}
	public WebDeployer() {
	}
	public WebDeployer(List<String> wars, List<String> jars) {
		super(wars, jars);
	}
	public String getExtraContent(
			double webXmlVersion, File srcFile, String displayName)
		throws Exception {
		StringBundler sb = new StringBundler(6);
		String extraContent = super.getExtraContent(
			webXmlVersion, srcFile, displayName);
		sb.append(extraContent);
				sb.append("<listener>");
		sb.append("<listener-class>");
		sb.append("com.liferay.portal.kernel.servlet.WebContextListener");
		sb.append("</listener-class>");
		sb.append("</listener>");
		return sb.toString();
	}
}