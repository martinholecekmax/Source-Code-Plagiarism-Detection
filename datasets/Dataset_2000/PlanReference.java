@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "plan_reference")
public class PlanReference {
    @XmlAttribute(name = "plan_id", required = true)
    protected String planId;
    @XmlAttribute(name = "start_time", required = true)
    protected BigDecimal startTime;
    
    public String getPlanId() {
        return planId;
    }
    
    public void setPlanId(String value) {
        this.planId = value;
    }
    
    public BigDecimal getStartTime() {
        return startTime;
    }
    
    public void setStartTime(BigDecimal value) {
        this.startTime = value;
    }
}