public class JaceBeleren extends mage.sets.magic2010.JaceBeleren {
    public JaceBeleren(UUID ownerId) {
        super(ownerId);
        this.cardNumber = 58;
        this.expansionSetCode = "M11";
    }
    public JaceBeleren(final JaceBeleren card) {
        super(card);
    }
    @Override
    public JaceBeleren copy() {
        return new JaceBeleren(this);
    }
}