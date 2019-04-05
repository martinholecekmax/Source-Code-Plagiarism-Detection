public class Vindicate extends CardImpl<Vindicate> {
    public Vindicate (UUID ownerId) {
        super(ownerId, 126, "Vindicate", Rarity.RARE, new CardType[]{CardType.SORCERY}, "{1}{W}{B}");
        this.expansionSetCode = "APC";
        this.color.setWhite(true);
        this.color.setBlack(true);
        this.getSpellAbility().addEffect(new DestroyTargetEffect());
        this.getSpellAbility().addTarget(new TargetPermanent());
    }
    public Vindicate (final Vindicate card) {
        super(card);
    }
    @Override
    public Vindicate copy() {
        return new Vindicate(this);
    }
}