public class StrongarmThug extends CardImpl<StrongarmThug> {
    private static final FilterCreatureCard filter = new FilterCreatureCard("Mercenary card");
    static {
        filter.add(new SubtypePredicate("Mercenary"));
    }
    public StrongarmThug(UUID ownerId) {
		super(ownerId, 165, "Strongarm Thug", Rarity.COMMON, new CardType[]{CardType.CREATURE}, "{2}{B}");
		this.expansionSetCode = "MMQ";
		this.subtype.add("Human");
		this.subtype.add("Mercenary");
		this.color.setBlack(true);
		this.power = new MageInt(1);
		this.toughness = new MageInt(1);
        		Ability ability = new EntersBattlefieldTriggeredAbility(new ReturnToHandTargetEffect(), true);
        ability.addTarget(new TargetCardInYourGraveyard(filter));
        this.addAbility(ability);
    }
    public StrongarmThug(final StrongarmThug card) {
        super(card);
    }
    @Override
    public StrongarmThug copy() {
        return new StrongarmThug(this);
    }
}