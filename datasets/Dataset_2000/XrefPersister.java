public class XrefPersister 
	extends Persister<Xref>
{
	private final ReferenceSourcePersister typePersister;
	protected XrefPersister ( DaoFactory daoFactory, Timestamp submissionTs ) {
		super ( daoFactory, submissionTs );
		typePersister = new ReferenceSourcePersister ( daoFactory, submissionTs ) {};
	}
	@Override
	protected void preProcess ( Xref xref ) 
	{
		super.preProcess ( xref );
				ReferenceSource source = xref.getSource ();
		ReferenceSource sourceDB = typePersister.persist ( source );
		if ( source != sourceDB )
			xref.setSource ( sourceDB );
	}
}