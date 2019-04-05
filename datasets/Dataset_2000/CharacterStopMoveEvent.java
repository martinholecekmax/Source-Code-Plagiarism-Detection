public class CharacterStopMoveEvent implements CharacterEvent {
	
	private final L2Character character;
	
	private final Point3D point;
	
	public CharacterStopMoveEvent(L2Character character, Point3D point) {
		this.character = character;
		this.point = point;
	}
	
	public Point3D getPoint() {
		return point;
	}
	@Override
	public Player getPlayer() {
		return character;
	}
	@Override
	public Actor getActor() {
		return character;
	}
	@Override
	public WorldObject getObject() {
		return character;
	}
	@Override
	public L2Character getCharacter() {
		return character;
	}
	@Override
	public ObjectID<?>[] getDispatchableObjects() {
		return new ObjectID<?>[] { character.getID() };
	}
}