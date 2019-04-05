@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InsertObservationResponse", propOrder = {
    "assignedObservationId"
})
@XmlRootElement(name = "InsertObservationResponse")
public class InsertObservationResponse implements SOSResponse {
    @XmlElement(name = "AssignedObservationId", required = true)
    @XmlSchemaType(name = "anyURI")
    private String assignedObservationId;
    
    InsertObservationResponse() {}
    
    public InsertObservationResponse(final String assignedObservationId) {
        this.assignedObservationId = assignedObservationId;
    }
    
    public String getAssignedObservationId() {
        return assignedObservationId;
    }
    
    @Override
    public boolean equals(final Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof InsertObservationResponse) {
            final InsertObservationResponse that = (InsertObservationResponse) object;
            return Utilities.equals(this.assignedObservationId, that.assignedObservationId);
        }
        return false;
    }
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + (this.assignedObservationId != null ? this.assignedObservationId.hashCode() : 0);
        return hash;
    }
    @Override
    public String toString() {
        return "class:InsertObservationResponse observation ID=" + assignedObservationId; 
    }
}