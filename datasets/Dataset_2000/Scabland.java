public class Scabland extends CardImpl<Scabland> {
    public Scabland(UUID ownerId) {
        super(ownerId, 331, "Scabland", Rarity.RARE, new CardType[]{CardType.LAND}, null);
        this.expansionSetCode = "TMP";
                this.addAbility(new EntersBattlefieldTappedAbility());
                this.addAbility(new ColorlessManaAbility());
                Ability ability = new RedManaAbility();
        ability.addEffect(new DamageControllerEffect(1));
        this.addAbility(ability);
        ability = new WhiteManaAbility();
        ability.addEffect(new DamageControllerEffect(1));
        this.addAbility(ability);
    }
    public Scabland(final Scabland card) {
        super(card);
    }
    @Override
    public Scabland copy() {
        return new Scabland(this);
    }
}