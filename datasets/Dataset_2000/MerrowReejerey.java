public class MerrowReejerey extends CardImpl<MerrowReejerey> {
    private static final FilterCreaturePermanent filter1 = new FilterCreaturePermanent("Merfolk creatures you control");
    private static final FilterSpell filter2 = new FilterSpell("Merfolk spell");
    static {
        filter1.add(new SubtypePredicate("Merfolk"));
        filter1.add(new ControllerPredicate(TargetController.YOU));
        filter2.add(new SubtypePredicate("Merfolk"));
    }
    public MerrowReejerey(UUID ownerId) {
        super(ownerId, 74, "Merrow Reejerey", Rarity.UNCOMMON, new CardType[]{CardType.CREATURE}, "{2}{U}");
        this.expansionSetCode = "LRW";
        this.subtype.add("Merfolk");
        this.subtype.add("Soldier");
        this.color.setBlue(true);
        this.power = new MageInt(2);
        this.toughness = new MageInt(2);
                this.addAbility(new SimpleStaticAbility(Zone.BATTLEFIELD, new BoostAllEffect(1, 1, Duration.WhileOnBattlefield, filter1, true)));
                Ability ability = new SpellCastTriggeredAbility(new MayTapOrUntapTargetEffect(), filter2, true);
        ability.addTarget(new TargetPermanent());
        this.addAbility(ability);
    }
    public MerrowReejerey(final MerrowReejerey card) {
        super(card);
    }
    @Override
    public MerrowReejerey copy() {
        return new MerrowReejerey(this);
    }
}