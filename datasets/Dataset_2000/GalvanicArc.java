public class GalvanicArc extends CardImpl<GalvanicArc> {
    public GalvanicArc(UUID ownerId) {
        super(ownerId, 126, "Galvanic Arc", Rarity.COMMON, new CardType[]{CardType.ENCHANTMENT}, "{2}{R}");
        this.expansionSetCode = "RAV";
        this.subtype.add("Aura");
        this.color.setRed(true);
                TargetPermanent auraTarget = new TargetCreaturePermanent();
        this.getSpellAbility().addTarget(auraTarget);
        this.getSpellAbility().addEffect(new AttachEffect(Constants.Outcome.BoostCreature));
        Ability ability = new EnchantAbility(auraTarget.getTargetName());
        this.addAbility(ability);
                Ability triggeredAbility = new EntersBattlefieldTriggeredAbility(new DamageTargetEffect(3));
        triggeredAbility.addTarget(new TargetCreatureOrPlayer());
        this.addAbility(triggeredAbility);
                this.addAbility(new SimpleStaticAbility(Constants.Zone.BATTLEFIELD, new GainAbilityAttachedEffect(FirstStrikeAbility.getInstance(), Constants.AttachmentType.AURA)));
    }
    public GalvanicArc(final GalvanicArc card) {
        super(card);
    }
    @Override
    public GalvanicArc copy() {
        return new GalvanicArc(this);
    }
}