public class WallPart {
    private String facadeMaterialType;
    private String roofMaterialType;
    private Color facadeColour;
    private Color roofColour;
    private List<WallNode> nodes;
        private List<BuildingWallElement> buildingElements;
    
    public List<WallNode> getNodes() {
        return this.nodes;
    }
    
    public void setNodes(List<WallNode> nodes) {
        this.nodes = nodes;
    }
    
    public List<BuildingWallElement> getBuildingElements() {
        return this.buildingElements;
    }
    
    public void setBuildingElements(List<BuildingWallElement> buildingElements) {
        this.buildingElements = buildingElements;
    }
    
    public String getFacadeMaterialType() {
        return this.facadeMaterialType;
    }
    
    public void setFacadeMaterialType(String facadeMaterialType) {
        this.facadeMaterialType = facadeMaterialType;
    }
    
    public String getRoofMaterialType() {
        return this.roofMaterialType;
    }
    
    public void setRoofMaterialType(String roofMaterialType) {
        this.roofMaterialType = roofMaterialType;
    }
    
    public Color getFacadeColour() {
        return this.facadeColour;
    }
    
    public void setFacadeColour(Color facadeColour) {
        this.facadeColour = facadeColour;
    }
    
    public Color getRoofColour() {
        return this.roofColour;
    }
    
    public void setRoofColour(Color roofColour) {
        this.roofColour = roofColour;
    }
}