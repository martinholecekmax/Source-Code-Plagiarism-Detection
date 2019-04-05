@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "conditionExprOrConditionList"
})
@XmlRootElement(name = "condition-list")
public class ConditionList {
    @XmlElements({
        @XmlElement(name = "condition-expr", type = ConditionExpr.class),
        @XmlElement(name = "condition-list", type = ConditionList.class)
    })
    protected List<Object> conditionExprOrConditionList;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String combine;
    
    public List<Object> getConditionExprOrConditionList() {
        if (conditionExprOrConditionList == null) {
            conditionExprOrConditionList = new ArrayList<Object>();
        }
        return this.conditionExprOrConditionList;
    }
    
    public String getCombine() {
        if (combine == null) {
            return "and";
        } else {
            return combine;
        }
    }
    
    public void setCombine(String value) {
        this.combine = value;
    }
}