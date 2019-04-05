public class SearchWCTemplateTest extends BaseTestCase {
	public void testSearchWCTemplate() throws Exception {
		int label = 1;
		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/web/guest/home/");
				assertEquals(RuntimeVariables.replace("Go to"),
					selenium.getText("				selenium.mouseOver("				selenium.waitForVisible("link=Control Panel");
				selenium.clickAt("link=Control Panel",
					RuntimeVariables.replace("Control Panel"));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("link=Web Content",
					RuntimeVariables.replace("Web Content"));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("link=Templates",
					RuntimeVariables.replace("Templates"));
				selenium.waitForPageToLoad("30000");
				boolean basicVisible = selenium.isVisible("link=\u00ab Basic");
				if (!basicVisible) {
					label = 2;
					continue;
				}
				selenium.clickAt("link=\u00ab Basic",
					RuntimeVariables.replace("\u00ab Basic"));
			case 2:
				selenium.waitForVisible("				selenium.type("					RuntimeVariables.replace("Template"));
				selenium.clickAt("					RuntimeVariables.replace("Search"));
				selenium.waitForPageToLoad("30000");
				selenium.type("					RuntimeVariables.replace(""));
				assertEquals(RuntimeVariables.replace("WC Template Name"),
					selenium.getText("				assertEquals(RuntimeVariables.replace("WC Template Description"),
					selenium.getText("				selenium.type("					RuntimeVariables.replace("Template1"));
				selenium.clickAt("					RuntimeVariables.replace("Search"));
				selenium.waitForPageToLoad("30000");
				selenium.type("					RuntimeVariables.replace(""));
				assertFalse(selenium.isTextPresent("WC Template Name"));
				assertFalse(selenium.isTextPresent("WC Template Description"));
			case 100:
				label = -1;
			}
		}
	}
}