public class BonfireOfTheDamned extends CardImpl<BonfireOfTheDamned> {
    public BonfireOfTheDamned(UUID ownerId) {
        super(ownerId, 129, "Bonfire of the Damned", Rarity.MYTHIC, new CardType[]{CardType.SORCERY}, "{X}{X}{R}");
        this.expansionSetCode = "AVR";
        this.color.setRed(true);
                this.getSpellAbility().addEffect(new BonfireOfTheDamnedEffect());
        this.getSpellAbility().addTarget(new TargetPlayer());
                this.addAbility(new MiracleAbility(new ManaCostsImpl("{X}{R}")));
    }
    public BonfireOfTheDamned(final BonfireOfTheDamned card) {
        super(card);
    }
    @Override
    public BonfireOfTheDamned copy() {
        return new BonfireOfTheDamned(this);
    }
}
class BonfireOfTheDamnedEffect extends OneShotEffect<BonfireOfTheDamnedEffect> {
    private static FilterPermanent filter = new FilterCreaturePermanent();
    public BonfireOfTheDamnedEffect() {
        super(Constants.Outcome.Damage);
        staticText = "Bonfire of the Damned deals X damage to target player and each creature he or she controls";
    }
    public BonfireOfTheDamnedEffect(final BonfireOfTheDamnedEffect effect) {
        super(effect);
    }
    @Override
    public boolean apply(Game game, Ability source) {
        Player player = game.getPlayer(source.getFirstTarget());
        if (player != null) {
           int damage = source.getManaCostsToPay().getX();
            if (damage > 0)  {
                player.damage(damage, source.getId(), game, false, true);
                for (Permanent perm: game.getBattlefield().getAllActivePermanents(filter, player.getId(), game)) {
                    perm.damage(damage, source.getId(), game, true, false);
                }
                return true;
            }
        }
        return false;
    }
    @Override
    public BonfireOfTheDamnedEffect copy() {
        return new BonfireOfTheDamnedEffect(this);
    }
}