public class RosterListWidget extends FlowPanel implements RosterListDisplay {
	public RosterListWidget() {
		ensureDebugId("hablar-RosterListWidget");
	}
	@Override
	public void add(final GroupHeaderDisplay headerDisplay, final RosterGroupDisplay groupDisplay) {
		add(headerDisplay.asWidget());
		add(groupDisplay.asWidget());
	}
	@Override
	public GroupHeaderDisplay createGroupHeader(final String groupId) {
		return new GroupHeaderWidget(groupId);
	}
	@Override
	public void remove(final GroupHeaderDisplay headerDisplay, final RosterGroupDisplay groupDisplay) {
		remove(headerDisplay.asWidget());
		remove(groupDisplay.asWidget());
	}
}