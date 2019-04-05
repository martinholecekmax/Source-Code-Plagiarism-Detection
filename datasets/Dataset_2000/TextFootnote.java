public class TextFootnote {
    protected TextFootnoteBody textFootnoteBody;
    protected TextFootnoteCitation textFootnoteCitation;
    protected String textId;
    
    public TextFootnoteBody getTextFootnoteBody() {
        return this.textFootnoteBody;
    }
    
    public TextFootnoteCitation getTextFootnoteCitation() {
        return this.textFootnoteCitation;
    }
    
    public String getTextId() {
        return this.textId;
    }
    
    public void setTextFootnoteBody(final TextFootnoteBody value) {
        this.textFootnoteBody = value;
    }
    
    public void setTextFootnoteCitation(final TextFootnoteCitation value) {
        this.textFootnoteCitation = value;
    }
    
    public void setTextId(final String value) {
        this.textId = value;
    }
}