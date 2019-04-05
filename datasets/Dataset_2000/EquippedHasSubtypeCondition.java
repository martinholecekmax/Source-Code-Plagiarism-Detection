public class EquippedHasSubtypeCondition implements Condition {
    private String subType;
    private String[] subTypes;     public EquippedHasSubtypeCondition(String subType) {
        this.subType = subType;
    }
    public EquippedHasSubtypeCondition(String... subTypes) {
        this.subTypes = subTypes;
    }
    @Override
    public boolean apply(Game game, Ability source) {
        Permanent permanent = game.getBattlefield().getPermanent(source.getSourceId());
        if (permanent != null && permanent.getAttachedTo() != null) {
            Permanent attachedTo = game.getBattlefield().getPermanent(permanent.getAttachedTo());
            if (attachedTo == null) {
                attachedTo = (Permanent) game.getLastKnownInformation(permanent.getAttachedTo(), Constants.Zone.BATTLEFIELD);
            }
            if (attachedTo != null) {
                if (subType != null) {
                    if (attachedTo.hasSubtype(this.subType)) {
                        return true;
                    }
                } else {
                    for (String s : subTypes) {
                        if (attachedTo.hasSubtype(s)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}