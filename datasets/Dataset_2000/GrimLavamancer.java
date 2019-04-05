public class GrimLavamancer extends mage.sets.magic2012.GrimLavamancer {
    public GrimLavamancer(UUID ownerId) {
        super(ownerId);
        this.cardNumber = 100;
        this.expansionSetCode = "TOR";
    }
    public GrimLavamancer(final GrimLavamancer card) {
        super(card);
    }
    @Override
    public GrimLavamancer copy() {
        return new GrimLavamancer(this);
    }
}