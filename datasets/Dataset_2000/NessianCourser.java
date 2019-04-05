public class NessianCourser extends CardImpl<NessianCourser> {
    public NessianCourser(UUID ownerId) {
        super(ownerId, 148, "Nessian Courser", Rarity.COMMON, new CardType[]{CardType.CREATURE}, "{2}{G}");
        this.expansionSetCode = "FUT";
        this.subtype.add("Centaur");
        this.subtype.add("Warrior");
        this.color.setGreen(true);
        this.power = new MageInt(3);
        this.toughness = new MageInt(3);
    }
    public NessianCourser(final NessianCourser card) {
        super(card);
    }
    @Override
    public NessianCourser copy() {
        return new NessianCourser(this);
    }
}