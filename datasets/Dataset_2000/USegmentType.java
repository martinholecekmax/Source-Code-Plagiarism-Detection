public enum USegmentType {
	SEG_MOVETO(PathIterator.SEG_MOVETO), SEG_LINETO(PathIterator.SEG_LINETO), SEG_QUADTO(PathIterator.SEG_QUADTO), SEG_CUBICTO(
			PathIterator.SEG_CUBICTO), SEG_CLOSE(PathIterator.SEG_CLOSE);
	private final int code;
	private USegmentType(int code) {
		this.code = code;
	}
	public static USegmentType getByCode(int code) {
		for (USegmentType p : EnumSet.allOf(USegmentType.class)) {
			if (p.code == code) {
				return p;
			}
		}
		throw new IllegalArgumentException();
	}
}