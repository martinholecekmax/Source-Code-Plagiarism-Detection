public enum GenericChessman {
	PAWN('P'),
	KNIGHT('N'),
	BISHOP('B'),
	ROOK('R'),
	QUEEN('Q'),
	KING('K');
	private static final GenericChessman[] promotions = new GenericChessman[]{QUEEN, ROOK, BISHOP, KNIGHT};
	private final char token;
	private GenericChessman(char token) {
		this.token = token;
	}
	public static GenericChessman valueOf(char input) {
		for (GenericChessman chessman: values()) {
			if (Character.toLowerCase(input) == Character.toLowerCase(chessman.token)) {
				return chessman;
			}
		}
		return null;
	}
	public static GenericChessman valueOfPromotion(char input) {
		for (GenericChessman chessman: promotions) {
			if (Character.toLowerCase(input) == Character.toLowerCase(chessman.token)) {
				return chessman;
			}
		}
		return null;
	}
	public boolean isValidPromotion() {
		for (GenericChessman chessman : promotions) {
			if (this == chessman) {
				return true;
			}
		}
		return false;
	}
	public char toCharAlgebraic() {
		if (this == PAWN) {
			throw new UnsupportedOperationException();
		}
		return this.token;
	}
	public char toChar(GenericColor color) {
		if (color == null) throw new IllegalArgumentException();
		return color.transform(this.token);
	}
}