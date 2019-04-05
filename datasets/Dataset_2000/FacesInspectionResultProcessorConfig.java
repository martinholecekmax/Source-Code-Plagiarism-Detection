public class FacesInspectionResultProcessorConfig {
				private PropertyStyle	mInjectThis;
	private String[]		mIgnoreAttributes	= new String[] { FACES_AJAX_ACTION, FACES_CONVERTER_ID, FACES_EXPRESSION, FACES_LOOKUP, FACES_LOOKUP_ITEM_LABEL, FACES_LOOKUP_ITEM_VALUE, FACES_SUGGEST };
				
	public FacesInspectionResultProcessorConfig setInjectThis( PropertyStyle injectThis ) {
		mInjectThis = injectThis;
				return this;
	}
	
	public FacesInspectionResultProcessorConfig setIgnoreAttributes( String... ignoreAttributes ) {
		mIgnoreAttributes = ignoreAttributes;
				return this;
	}
	@Override
	public boolean equals( Object that ) {
		if ( this == that ) {
			return true;
		}
		if ( !ObjectUtils.nullSafeClassEquals( this, that ) ) {
			return false;
		}
		if ( !ObjectUtils.nullSafeEquals( mInjectThis, ( (FacesInspectionResultProcessorConfig) that ).mInjectThis ) ) {
			return false;
		}
		if ( !ObjectUtils.nullSafeEquals( mIgnoreAttributes, ( (FacesInspectionResultProcessorConfig) that ).mIgnoreAttributes ) ) {
			return false;
		}
		return true;
	}
	@Override
	public int hashCode() {
		int hashCode = 1;
		hashCode = 31 * hashCode + ObjectUtils.nullSafeHashCode( mInjectThis );
		hashCode = 31 * hashCode + ObjectUtils.nullSafeHashCode( mIgnoreAttributes );
		return hashCode;
	}
				protected PropertyStyle getInjectThis() {
		return mInjectThis;
	}
	protected String[] getIgnoreAttributes() {
		return mIgnoreAttributes;
	}
}