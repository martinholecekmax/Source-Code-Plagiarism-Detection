public class VeteranSwordsmith extends CardImpl<VeteranSwordsmith> {
    private final static FilterCreaturePermanent filter = new FilterCreaturePermanent("Soldier");
    static {
        filter.add(new SubtypePredicate("Soldier"));
    }
    public VeteranSwordsmith(UUID ownerId) {
        super(ownerId, 39, "Veteran Swordsmith", Rarity.COMMON, new CardType[]{CardType.CREATURE}, "{2}{W}");
        this.expansionSetCode = "M10";
        this.subtype.add("Human");
        this.subtype.add("Soldier");
        this.color.setWhite(true);
        this.power = new MageInt(3);
        this.toughness = new MageInt(2);
        this.addAbility(new SimpleStaticAbility(Constants.Zone.BATTLEFIELD, new BoostControlledEffect(1, 0, Constants.Duration.WhileOnBattlefield, filter, true)));
    }
    public VeteranSwordsmith(final VeteranSwordsmith card) {
        super(card);
    }
    @Override
    public VeteranSwordsmith copy() {
        return new VeteranSwordsmith(this);
    }
}