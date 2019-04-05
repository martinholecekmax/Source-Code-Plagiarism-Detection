public class SkullUpdateEvent extends Event {
	public static final int TIME = 5000;
	public SkullUpdateEvent() {
		super(TIME);
	}
	@Override
	public void execute() {
		for(Player p : World.getWorld().getPlayers()) {
			p.getHeadIcons().decCycle();
			if(p.getHeadIcons().removeSkulls()) {
				p.getUpdateFlags().setAppearanceUpdateRequired(true);
			}
		}
	}
}