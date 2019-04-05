public class MyrTurbine extends CardImpl<MyrTurbine> {
    private static final FilterCreatureCard filterCard = new FilterCreatureCard("Myr creature card");
    private static final FilterControlledPermanent filterMyr = new FilterControlledPermanent("Myr you control");
    static {
        filterCard.add(new SubtypePredicate("Myr"));
        filterMyr.add(new SubtypePredicate("Myr"));
    }
    public MyrTurbine(UUID ownerId) {
        super(ownerId, 117, "Myr Turbine", Rarity.RARE, new CardType[]{CardType.ARTIFACT}, "{5}");
        this.expansionSetCode = "MBS";
        this.addAbility(new SimpleActivatedAbility(Zone.BATTLEFIELD,
                new CreateTokenEffect(new MyrToken()),
                new TapSourceCost()));
        SimpleActivatedAbility ability = new SimpleActivatedAbility(Zone.BATTLEFIELD,
                new SearchLibraryPutInPlayEffect(new TargetCardInLibrary(filterCard)),
                new TapSourceCost());
        ability.addCost(new TapTargetCost(new TargetControlledPermanent(5, 5, filterMyr, true)));
        this.addAbility(ability);
    }
    public MyrTurbine(final MyrTurbine card) {
        super(card);
    }
    @Override
    public MyrTurbine copy() {
        return new MyrTurbine(this);
    }
}