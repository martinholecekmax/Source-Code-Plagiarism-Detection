public class HorrifyingRevelation extends CardImpl<HorrifyingRevelation> {
    public HorrifyingRevelation(UUID ownerId) {
        super(ownerId, 45, "Horrifying Revelation", Rarity.COMMON, new CardType[]{CardType.SORCERY}, "{B}");
        this.expansionSetCode = "MBS";
        this.color.setBlack(true);
        this.getSpellAbility().addTarget(new TargetPlayer());
        this.getSpellAbility().addEffect(new DiscardTargetEffect(1));
        this.getSpellAbility().addEffect(new PutLibraryIntoGraveTargetEffect(1));
    }
    public HorrifyingRevelation(final HorrifyingRevelation card) {
        super(card);
    }
    @Override
    public HorrifyingRevelation copy() {
        return new HorrifyingRevelation(this);
    }
}