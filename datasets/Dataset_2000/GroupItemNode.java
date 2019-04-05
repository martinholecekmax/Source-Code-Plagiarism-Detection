public class GroupItemNode extends ATabNode<Group> {
	public GroupItemNode(Group group) {
		super(group);
	}
	@Override
	public String toString() {
		return getComponent().getLabel();
	}
	@Override
	protected ITabComponent<Group> createComponent() {
		return new GroupsJPanel(getUserObject(), this);
	}
	@Override
	public void clickAction(int clickCount) {
		if (clickCount == 2 && !isOpened()) {
			((GroupsJPanel) getComponent()).doReload();
		}
		super.clickAction(clickCount);
	}
}