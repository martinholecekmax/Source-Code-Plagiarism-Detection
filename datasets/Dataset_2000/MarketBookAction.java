public enum MarketBookAction implements Value<MarketBookAction> {
	
	NOOP, 	
	MODIFY, 	
	REMOVE, 	;
	public final byte ord = (byte) ordinal();
	private static final MarketBookAction[] ENUM_VALUES = values();
	public static final MarketBookAction fromOrd(final byte ord) {
		return ENUM_VALUES[ord];
	}
	@Override
	public MarketBookAction freeze() {
		return this;
	}
	@Override
	public boolean isFrozen() {
		return true;
	}
	@Override
	public boolean isNull() {
		return this == NOOP;
	}
}