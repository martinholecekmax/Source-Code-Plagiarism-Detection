public class DefaultOrdinalPosition extends DefaultTemporalPosition implements OrdinalPosition {
    
    private OrdinalEra ordinalPosition;
    public DefaultOrdinalPosition(TemporalReferenceSystem frame, IndeterminateValue indeterminatePosition, OrdinalEra ordinalPosition) {
        super(frame, indeterminatePosition);
        this.ordinalPosition = ordinalPosition;
    }
    
    public OrdinalEra getOrdinalPosition() {
        return ordinalPosition;
    }
    public void setOrdinalPosition(OrdinalEra ordinalPosition) {
        this.ordinalPosition = ordinalPosition;
    }
    @Override
    public boolean equals(final Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof DefaultOrdinalPosition && super.equals(object)) {
            final DefaultOrdinalPosition that = (DefaultOrdinalPosition) object;
            return Utilities.equals(this.ordinalPosition, that.ordinalPosition);
        }
        return false;
    }
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + (this.ordinalPosition != null ? this.ordinalPosition.hashCode() : 0);
        return hash;
    }
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("OrdinalPosition:").append('\n');
        if (ordinalPosition != null) {
            s.append("ordinalPosition:").append(ordinalPosition).append('\n');
        }
        return s.toString();
    }
}