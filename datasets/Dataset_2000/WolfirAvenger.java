public class WolfirAvenger extends CardImpl<WolfirAvenger> {
    public WolfirAvenger(UUID ownerId) {
        super(ownerId, 205, "Wolfir Avenger", Rarity.UNCOMMON, new CardType[]{CardType.CREATURE}, "{1}{G}{G}");
        this.expansionSetCode = "AVR";
        this.subtype.add("Wolf");
        this.subtype.add("Warrior");
        this.color.setGreen(true);
        this.power = new MageInt(3);
        this.toughness = new MageInt(3);
        this.addAbility(FlashAbility.getInstance());
                this.addAbility(new SimpleActivatedAbility(Constants.Zone.BATTLEFIELD, new RegenerateSourceEffect(), new ManaCostsImpl("{1}{G}")));
    }
    public WolfirAvenger(final WolfirAvenger card) {
        super(card);
    }
    @Override
    public WolfirAvenger copy() {
        return new WolfirAvenger(this);
    }
}