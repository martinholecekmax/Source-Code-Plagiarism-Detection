public class ManageRolePage  extends MifosPage {
    public ManageRolePage(Selenium selenium) {
        super(selenium);
    }
    public ManageRolePage verifyPage() {
        verifyPage("managerole");
        return this;
    }
    public ManageRolePage disablePermission(String permissionValue) {
        Assert.assertEquals(selenium.getValue(permissionValue), "on");
        selenium.click(permissionValue);
        return this;
    }
    public ManageRolePage enablePermission(String permissionValue) {
        Assert.assertEquals("off", selenium.getValue(permissionValue));
        selenium.click(permissionValue);
        return this;
    }
    public ViewRolesPage submitAndGotoViewRolesPage() {
        selenium.click("managerole.button.submit");
        waitForPageToLoad();
        return new ViewRolesPage(selenium);
    }
    public Boolean isPermissionEnable(String permisson) {
    	return selenium.getValue(permisson).equalsIgnoreCase("on");
    }
    public ManageRolePage verifyPermissionText(String permisson, String description) {
        Assert.assertEquals(2,selenium.getXpathCount("        return this;
    }
}