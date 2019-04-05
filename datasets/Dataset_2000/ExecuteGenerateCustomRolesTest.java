public class ExecuteGenerateCustomRolesTest extends BaseTestCase {
	public void testExecuteGenerateCustomRoles() throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home");
		selenium.waitForElementPresent("link=Control Panel");
		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Server Administration",
			RuntimeVariables.replace("Server Administration"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Data Migration",
			RuntimeVariables.replace("Data Migration"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Convert legacy permission algorithm."),
			selenium.getText("		assertTrue(selenium.isElementPresent(
				"		assertFalse(selenium.isChecked(
				"		selenium.clickAt("			RuntimeVariables.replace("Generate Custom Roles Checkbox"));
		assertTrue(selenium.isChecked(
				"		selenium.clickAt("			RuntimeVariables.replace("Execute"));
	}
}