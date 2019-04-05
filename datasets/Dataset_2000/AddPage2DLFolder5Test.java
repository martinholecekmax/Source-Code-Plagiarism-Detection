public class AddPage2DLFolder5Test extends BaseTestCase {
	public void testAddPage2DLFolder5() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/document-library-page-scope-community/");
		selenium.waitForVisible("link=DL Page2 Name");
		selenium.clickAt("link=DL Page2 Name",
			RuntimeVariables.replace("DL Page2 Name"));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(5000);
		selenium.waitForText("			"Documents and Media (DL Page2 Name)");
		assertEquals(RuntimeVariables.replace(
				"Documents and Media (DL Page2 Name)"),
			selenium.getText("		assertEquals(RuntimeVariables.replace("Add"),
			selenium.getText("		selenium.clickAt("			RuntimeVariables.replace("Add"));
		selenium.waitForVisible(
			"		assertEquals(RuntimeVariables.replace("Folder"),
			selenium.getText(
				"		selenium.click(RuntimeVariables.replace(
				"		selenium.waitForPageToLoad("30000");
		selenium.type("			RuntimeVariables.replace("DL Folder5 Name"));
		selenium.clickAt("			RuntimeVariables.replace("Save"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("		assertEquals(RuntimeVariables.replace("DL Folder2 Name"),
			selenium.getText(
				"xPath=(		assertEquals(RuntimeVariables.replace("DL Folder3 Name"),
			selenium.getText(
				"xPath=(		assertEquals(RuntimeVariables.replace("DL Folder4 Name"),
			selenium.getText(
				"xPath=(		assertEquals(RuntimeVariables.replace("DL Folder5 Name"),
			selenium.getText(
				"xPath=(	}
}