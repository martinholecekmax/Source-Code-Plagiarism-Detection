public class ElementTextContains extends AbstractElementAndTextBooleanCondition {
    public ElementTextContains(WebElement element, String text) {
        super(element, text);
    }
    public ElementTextContains(WebElement element, String text, boolean negation) {
        super(element, text, negation);
    }
    @Override
    protected Boolean check(WebDriver driver) {
        return getElement().getText().contains(getText());
    }
}