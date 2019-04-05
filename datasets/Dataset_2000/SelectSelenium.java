public class SelectSelenium extends SingleValuedComponentSelenium {
    public SelectSelenium() {
        this.widgetValues = new SelectValues();
        this.widgetInteraction = new SelectInteraction(widgetValues);
    }
    private static SeleniumSetupSuite seleniumSetupSuite;
    public static Test suite() {
        seleniumSetupSuite = new SeleniumSetupSuite(new TestSuite(
                SelectSelenium.class));
        return seleniumSetupSuite;
    }
    public void setUp() throws Exception {
        selenium = seleniumSetupSuite.getSelenium();
        if (selenium != null) {
            this.widgetInteraction.setSelenium(selenium);
            selenium
                    .open("http:        }
    }
    protected void checkEmptyConditionRequiredValidator() {
    }
    protected void checkEmptySubmittedValueNull() {
    }
    protected void checkRequiredAttribute() {
    }
    protected void checkWithMultipleValidatorsEmptyCondition() {
    }
    protected void checkForBadValueInConverter() {
    }
    public void testEmptySubmitConditionParamFalse() throws Exception {
    }
    @Override
    protected void checkForReadOnly() throws Exception {
                verifyEquals(
                "The Initial value of the readonly component was not correct.",
                widgetValues.getDisplayedValues(VariableName.FIRST),
                widgetInteraction
                        .getDisplayedValue("form:readonlyDisabled:widgetReadOnly"));
        verifyFalse("The component could not be set readonly", selenium
                .isEditable("form:readonlyDisabled:widgetReadOnly"));
    }
}