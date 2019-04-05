public class AwakenerDruid extends mage.sets.magic2010.AwakenerDruid {
    public AwakenerDruid(UUID ownerId) {
        super(ownerId);
        this.cardNumber = 163;
        this.expansionSetCode = "M11";
    }
    public AwakenerDruid(final AwakenerDruid card) {
        super(card);
    }
    @Override
    public AwakenerDruid copy() {
        return new AwakenerDruid(this);
    }
}