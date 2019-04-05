public class CabalCoffers extends mage.sets.planechase.CabalCoffers {
    public CabalCoffers(UUID ownerId) {
        super(ownerId);
        this.cardNumber = 139;
        this.expansionSetCode = "TOR";
    }
    public CabalCoffers(final CabalCoffers card) {
        super(card);
    }
    @Override
    public CabalCoffers copy() {
        return new CabalCoffers(this);
    }
}