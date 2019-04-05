public class StateList extends ModelList {
	private SelectModelImpl selectModel;
	public StateList(List<State> states) {
		Collections.sort(states);
		List<OptionModel> options = CollectionFactory.newList();
		for (State state : states) {
			options.add(new OptionModelImpl(state.getTitle(), state));
		}
		selectModel = new SelectModelImpl(null, options);
	}
	@Override
	protected SelectModel getSelectModel() {
		return selectModel;
	}
}