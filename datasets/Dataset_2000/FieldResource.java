public class FieldResource extends AbstractField {
    private String description;
    private Image image;
    
    public FieldResource() {
        description = MarkerMessages.description_resource;
    }
    
    public String getDescription() {
        return description;
    }
    
    public Image getDescriptionImage() {
        return image;
    }
    
    public String getColumnHeaderText() {
        return description;
    }
    
    public Image getColumnHeaderImage() {
        return image;
    }
    
    public String getValue(Object obj) {
        if (obj == null || !(obj instanceof ConcreteMarker)) {
            return "";         }
        ConcreteMarker marker = (ConcreteMarker) obj;
        return marker.getResourceName();
    }
    
    public Image getImage(Object obj) {
        return null;
    }
    
    public int compare(Object obj1, Object obj2) {
        if (obj1 == null || obj2 == null || !(obj1 instanceof ConcreteMarker)
                || !(obj2 instanceof ConcreteMarker)) {
            return 0;
        }
        ConcreteMarker marker1 = (ConcreteMarker) obj1;
        ConcreteMarker marker2 = (ConcreteMarker) obj2;
        return marker1.getResourceName().compareTo(
                marker2.getResourceName());
    }
    
	public int getDefaultDirection() {
		return TableComparator.ASCENDING;
	}
	
	public int getPreferredWidth() {
		return 75;
	}
}