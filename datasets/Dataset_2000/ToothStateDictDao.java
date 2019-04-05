public interface ToothStateDictDao {
	List<ToothState> getAllToothStates();
	long addToothState(ToothState toothState);
	void deleteToothState(ToothState toothState);
	ToothState getToothStateById(long toothStateId);
	void updateToothState(ToothState toothState);
}