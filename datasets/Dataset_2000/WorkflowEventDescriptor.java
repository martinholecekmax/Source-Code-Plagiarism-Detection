public class WorkflowEventDescriptor {
    private Version version;
    
    public WorkflowEventDescriptor(Version version) {
        Validate.notNull(version);
        this.version = version;
    }
    
    public Version getVersion() {
        return this.version;
    }
    public String toString() {
        return "workflow:" + this.version.getEvent() + "->" + this.version.getState();
    }
}