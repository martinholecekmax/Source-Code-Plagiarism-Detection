public class User1_SearchFolderImageTest extends BaseTestCase {
	public void testUser1_SearchFolderImage() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForVisible("link=Documents and Media Test Page");
		selenium.clickAt("link=Documents and Media Test Page",
			RuntimeVariables.replace("Documents and Media Test Page"));
		selenium.waitForPageToLoad("30000");
		selenium.type("			RuntimeVariables.replace("dog"));
		selenium.clickAt("			RuntimeVariables.replace("Search"));
		selenium.waitForText("			"DL Folder 1 Image 1 Title");
		assertEquals(RuntimeVariables.replace("DL Folder 1 Image 1 Title"),
			selenium.getText("		selenium.type("			RuntimeVariables.replace("cat"));
		selenium.clickAt("			RuntimeVariables.replace("Search"));
		selenium.waitForText("			"DL Folder 2 Image 2 Title");
		assertEquals(RuntimeVariables.replace("DL Folder 2 Image 2 Title"),
			selenium.getText("		selenium.type("			RuntimeVariables.replace("fish"));
		selenium.clickAt("			RuntimeVariables.replace("Search"));
		selenium.waitForText("			"No documents were found that matched the keywords: fish.");
		assertEquals(RuntimeVariables.replace(
				"No documents were found that matched the keywords: fish."),
			selenium.getText("		selenium.type("			RuntimeVariables.replace("frog"));
		selenium.clickAt("			RuntimeVariables.replace("Search"));
		selenium.waitForText("			"No documents were found that matched the keywords: frog.");
		assertEquals(RuntimeVariables.replace(
				"No documents were found that matched the keywords: frog."),
			selenium.getText("	}
}