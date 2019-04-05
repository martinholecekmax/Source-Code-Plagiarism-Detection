public class VampiricSpirit extends CardImpl<VampiricSpirit> {
    public VampiricSpirit(UUID ownerId) {
        super(ownerId, 170, "Vampiric Spirit", Rarity.RARE, new CardType[]{CardType.CREATURE}, "{2}{B}{B}");
        this.expansionSetCode = "8ED";
        this.subtype.add("Spirit");
        this.color.setBlack(true);
        this.power = new MageInt(4);
        this.toughness = new MageInt(3);
                this.addAbility(FlyingAbility.getInstance());
                this.addAbility(new EntersBattlefieldTriggeredAbility(new LoseLifeControllerEffect(4)));
    }
    public VampiricSpirit(final VampiricSpirit card) {
        super(card);
    }
    @Override
    public VampiricSpirit copy() {
        return new VampiricSpirit(this);
    }
}