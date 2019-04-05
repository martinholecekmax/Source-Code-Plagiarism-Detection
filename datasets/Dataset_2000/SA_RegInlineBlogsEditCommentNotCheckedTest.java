public class SA_RegInlineBlogsEditCommentNotCheckedTest extends BaseTestCase {
	public void testSA_RegInlineBlogsEditCommentNotChecked()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.waitForElementPresent("link=Blogs Permissions Page");
		selenium.clickAt("link=Blogs Permissions Page",
			RuntimeVariables.replace("Blogs Permissions Page"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("			RuntimeVariables.replace("Blogs Entry Title Temporary"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Permissions",
			RuntimeVariables.replace("Permissions"));
		selenium.waitForPageToLoad("30000");
		assertFalse(selenium.isChecked(
				"	}
}