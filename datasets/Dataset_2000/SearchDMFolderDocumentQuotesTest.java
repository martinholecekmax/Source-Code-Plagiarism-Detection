public class SearchDMFolderDocumentQuotesTest extends BaseTestCase {
	public void testSearchDMFolderDocumentQuotes() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Documents and Media Test Page");
		selenium.clickAt("link=Documents and Media Test Page",
			RuntimeVariables.replace("Documents and Media Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.type("			RuntimeVariables.replace("\"DM Folder Document Title\""));
		selenium.clickAt("			RuntimeVariables.replace("Search"));
		selenium.waitForVisible("		assertEquals(RuntimeVariables.replace(
				"Searched for \"DM Folder Document Title\" everywhere."),
			selenium.getText("		assertEquals(RuntimeVariables.replace("DM Folder Document Title"),
			selenium.getText(
				"		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Documents and Media Test Page");
		selenium.clickAt("link=Documents and Media Test Page",
			RuntimeVariables.replace("Documents and Media Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.type("			RuntimeVariables.replace("\"DM Folder Document Title 1\""));
		selenium.clickAt("			RuntimeVariables.replace("Search"));
		selenium.waitForVisible("		assertEquals(RuntimeVariables.replace(
				"Searched for \"DM Folder Document Title 1\" everywhere."),
			selenium.getText("		assertTrue(selenium.isElementNotPresent(
				"		assertTrue(selenium.isElementNotPresent("link=DM Folder Document Title"));
	}
}