public class GroundPrototype {
    private static final String FILE_NAME = "grounds.dat";
    private static HashMap<Character, GroundPrototype> protos = new HashMap<Character, GroundPrototype>();
    private static HashMap<String, Character> protoNames = new HashMap<String, Character>();
    private String name;
    private GroundType type;
    private char symbol;
    private String cName;
    private int cBrightness;
    private int speed;
    private int hp;
    private double burningFactor;
    public GroundPrototype(String[] attributes) {
	name = attributes[2];
	type = GroundType.get(attributes[3]);
	String[] colorInfo = attributes[4].split(" ");
	symbol = attributes[1].charAt(0);
	cName = colorInfo[0];
	cBrightness = Integer.parseInt(colorInfo[1]);
	speed = Integer.parseInt(attributes[5]);
	hp = Integer.parseInt(attributes[6]);
	burningFactor = Double.parseDouble(attributes[7]);
    }
    public static void loadPrototypes() {
	GroundType.loadTypes();
	for (String[] attributes : Util.getPrototypeAttributes(FILE_NAME, ";")) {
	    GroundPrototype proto = new GroundPrototype(attributes);
	    protos.put(attributes[0].charAt(0), proto);
	    protoNames.put(proto.name, attributes[0].charAt(0));
	}
    }
    public static GroundPrototype getProto(char c) {
	return protos.get(c);
    }
    public static GroundPrototype getProto(String name) {
	return protos.get(protoNames.get(name));
    }
    public String getName() {
	return name;
    }
    public char getSymbol() {
	return symbol;
    }
    public String getColorName() {
	return cName;
    }
    public int getColorBrightness() {
	return cBrightness;
    }
    public int getSpeed() {
	return speed;
    }
    public GroundType getType() {
	return type;
    }
    public int getHp() {
	return hp;
    }
    public double getBurningFactor() {
	return burningFactor;
    }
}