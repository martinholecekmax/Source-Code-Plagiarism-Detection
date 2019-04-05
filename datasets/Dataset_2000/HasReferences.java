@MappedSuperclass
public abstract class HasReferences extends Accessible {
	private Collection<Xref> refs = new ArrayList<Xref>();
	@Transient
	public Collection<Xref> getXrefs () {
		return this.refs;
	}
	public void addXref ( Xref ref ) {
		this.refs.add (  ref );
  }
	protected void setXrefs ( Collection<Xref> refs ) {
    this.refs = refs;
	}
	public boolean removeXref ( Xref xref ) {
		return this.refs.remove(xref);
	}
	
	@SuppressWarnings("unchecked")
	public List<Xref> getXrefs ( final String sourceAcc ) 
	{
		return (List<Xref>) CollectionUtils.select ( refs, new Predicate () {
			public boolean evaluate ( Object xref ) {
				ReferenceSource source = ((Xref) xref).getSource ();
				if ( source == null ) return false;
				if ( sourceAcc == null ) return source.getAcc () == null;
				return sourceAcc.equals ( source.getAcc () );
			}
		} 
		);
	}
	
	public Xref getSingleXref ( final String sourceAcc ) {
		List<Xref> xrefs = getXrefs ( sourceAcc );
		return xrefs.size () == 0 ? null : xrefs.get ( 0 );
	} 
	
	@SuppressWarnings("unchecked")
	public List<Xref> getXrefsContaining ( final String sourceAcc ) 
	{
		return (List<Xref>) CollectionUtils.select ( refs, new Predicate () {
			public boolean evaluate ( Object xref ) {
				ReferenceSource source = ((Xref) xref).getSource ();
				if ( source == null ) return false;
				if ( sourceAcc == null ) return source.getAcc () == null;
				return StringUtils.containsIgnoreCase ( source.getAcc (), sourceAcc );
			}
		} 
		);
	}
	
	public Xref getSingleXrefContaining ( final String sourceAcc ) {
		List<Xref> xrefs = getXrefsContaining ( sourceAcc );
		return xrefs.size () == 0 ? null : xrefs.get ( 0 );
	} 
}