public class AddDMFolderDocument2DMDTest extends BaseTestCase {
	public void testAddDMFolderDocument2DMD() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Documents and Media Display Test Page",
			RuntimeVariables.replace("Documents and Media Display Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("DM Folder Name"),
			selenium.getText("		selenium.clickAt("			RuntimeVariables.replace("DM Folder Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("DM Folder Name"),
			selenium.getText("		assertEquals(RuntimeVariables.replace("Add Document"),
			selenium.getText(
				"		selenium.clickAt("			RuntimeVariables.replace("Add Document"));
		selenium.waitForVisible("		selenium.selectFrame("		selenium.waitForElementPresent(
			"		selenium.waitForVisible("		selenium.clickAt("			RuntimeVariables.replace("Basic Document"));
		selenium.waitForPageToLoad("30000");
		selenium.selectFrame("relative=top");
		selenium.uploadCommonFile("			RuntimeVariables.replace("Document_2.txt"));
		selenium.type("			RuntimeVariables.replace("DM Folder Document2 Title"));
		selenium.clickAt("			RuntimeVariables.replace("Publish"));
		selenium.waitForPageToLoad("30000");
		selenium.waitForVisible("		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("		assertEquals(RuntimeVariables.replace("DM Folder Document2 Title"),
			selenium.getText("xPath=(	}
}