@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateProject", propOrder = {
    "projectId",
    "projectSpec"
})
public class UpdateProject {
    protected ProjectIdDataObj projectId;
    protected ProjectSpecDataObj projectSpec;
    
    public ProjectIdDataObj getProjectId() {
        return projectId;
    }
    
    public void setProjectId(ProjectIdDataObj value) {
        this.projectId = value;
    }
    
    public ProjectSpecDataObj getProjectSpec() {
        return projectSpec;
    }
    
    public void setProjectSpec(ProjectSpecDataObj value) {
        this.projectSpec = value;
    }
}