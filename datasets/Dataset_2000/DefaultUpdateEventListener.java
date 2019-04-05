public class DefaultUpdateEventListener extends DefaultSaveOrUpdateEventListener {
	protected Serializable performSaveOrUpdate(SaveOrUpdateEvent event) {
						EntityEntry entry = event.getSession().getPersistenceContext().getEntry( event.getEntity() );
		if ( entry!=null ) {
			if ( entry.getStatus()== Status.DELETED ) {
				throw new ObjectDeletedException( "deleted instance passed to update()", null, event.getEntityName() );
			}
			else {
				return entityIsPersistent(event);
			}
		}
		else {
			entityIsDetached(event);
			return null;
		}
	}
	
	protected Serializable getUpdateId(
			Object entity,
			EntityPersister persister,
			Serializable requestedId,
			SessionImplementor session) throws HibernateException {
		if ( requestedId == null ) {
			return super.getUpdateId( entity, persister, requestedId, session );
		}
		else {
			persister.setIdentifier( entity, requestedId, session );
			return requestedId;
		}
	}
}