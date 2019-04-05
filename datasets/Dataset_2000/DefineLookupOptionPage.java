public class DefineLookupOptionPage extends MifosPage {
    public DefineLookupOptionPage(Selenium selenium) {
        super(selenium);
        verifyPage("defineonelookupoption");
    }
    public DefineLookupOptionsPage fillFormAndSubmit(DefineLookupOptionParameters lookupOptionParams) {
        selenium.type("lookupValue", lookupOptionParams.getName());
        selenium.click("defineLookupOption.button.submit");
        waitForPageToLoad();
        return new DefineLookupOptionsPage(selenium);
    }
}