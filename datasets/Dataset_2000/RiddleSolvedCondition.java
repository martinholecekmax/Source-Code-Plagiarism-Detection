@SuppressWarnings("serial")
public class RiddleSolvedCondition extends Condition implements Serializable {
    
    private String riddleId;
    
    public String getRiddleId() {
        return riddleId;
    }
    
    public void setRiddleId(String riddleId) {
        this.riddleId = riddleId;
    }
}