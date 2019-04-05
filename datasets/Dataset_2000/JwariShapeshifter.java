public class JwariShapeshifter extends CardImpl<JwariShapeshifter> {
    final static private FilterPermanent filter = new FilterPermanent("Ally creature");
    static {
        filter.add(new SubtypePredicate("Ally"));
        filter.add(new CardTypePredicate(CardType.CREATURE));
    }
    public JwariShapeshifter(UUID ownerId) {
        super(ownerId, 32, "Jwari Shapeshifter", Rarity.RARE, new CardType[]{CardType.CREATURE}, "{1}{U}");
        this.expansionSetCode = "WWK";
        this.subtype.add("Shapeshifter");
        this.subtype.add("Ally");
        this.color.setBlue(true);
        this.power = new MageInt(0);
        this.toughness = new MageInt(0);
                Ability ability = new SimpleStaticAbility(Constants.Zone.BATTLEFIELD, new EntersBattlefieldEffect(new CopyPermanentEffect(filter), "You may have {this} enter the battlefield as a copy of any Ally creature on the battlefield"));
        this.addAbility(ability);
    }
    public JwariShapeshifter(final JwariShapeshifter card) {
        super(card);
    }
    @Override
    public JwariShapeshifter copy() {
        return new JwariShapeshifter(this);
    }
}