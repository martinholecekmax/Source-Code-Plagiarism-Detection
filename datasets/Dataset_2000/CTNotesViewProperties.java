@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_NotesViewProperties", propOrder = {
    "cSldViewPr",
    "extLst"
})
public class CTNotesViewProperties {
    @XmlElement(required = true)
    protected CTCommonSlideViewProperties cSldViewPr;
    protected CTExtensionList extLst;
    
    public CTCommonSlideViewProperties getCSldViewPr() {
        return cSldViewPr;
    }
    
    public void setCSldViewPr(CTCommonSlideViewProperties value) {
        this.cSldViewPr = value;
    }
    
    public CTExtensionList getExtLst() {
        return extLst;
    }
    
    public void setExtLst(CTExtensionList value) {
        this.extLst = value;
    }
}