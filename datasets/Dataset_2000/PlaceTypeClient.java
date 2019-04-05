public class PlaceTypeClient
        implements IsSerializable {
    
    protected List<PlaceTermTypeClient> placeTerm;
    
    public List<PlaceTermTypeClient> getPlaceTerm() {
        return this.placeTerm;
    }
    
    public void setPlaceTerm(List<PlaceTermTypeClient> placeTerm) {
        this.placeTerm = placeTerm;
    }
}