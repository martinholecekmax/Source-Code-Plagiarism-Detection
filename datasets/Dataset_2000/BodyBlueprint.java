public class BodyBlueprint {
	private final BodyDef bodyDef;
	private final FixtureDef fixtureDef;
	public final char ID;
	public BodyBlueprint(char ID, BodyDef bodyDef, FixtureDef fixtureDef) {
		this.bodyDef = bodyDef;
		this.fixtureDef = fixtureDef;
		this.ID = ID;
	}
	public BodyDef getBodyDef() {
		return bodyDef;
	}
	public FixtureDef getFixtureDef() {
		return fixtureDef;
	}
}