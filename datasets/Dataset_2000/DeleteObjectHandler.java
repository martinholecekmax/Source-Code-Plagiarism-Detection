@MessageHandler(modules="lrc-base",
                keywords={"lrc13","lrcjava1","lrc1516","lrc1516e"},
                sinks="outgoing",
                messages=DeleteObject.class)
public class DeleteObjectHandler extends LRCMessageHandler
{
													public void initialize( Map<String,Object> properties )
	{
		super.initialize( properties );
	}
	public void process( MessageContext context ) throws Exception
	{
		DeleteObject request = context.getRequest( DeleteObject.class, this );
		int objectHandle = request.getObjectHandle();
				lrcState.checkJoined();
		lrcState.checkSave();
		lrcState.checkRestore();
		if( logger.isDebugEnabled() )
		{
			String timeStatus = request.isTimestamped() ? " @"+request.getTimestamp() : " (RO)";
			logger.debug( "ATTEMPT Delete object ["+objectMoniker(objectHandle)+"]" + timeStatus );
		}
				if( request.isTimestamped() )
			lrcState.checkValidTime( request.getTimestamp() );
				OCInstance instance = repository.getInstance( objectHandle );
		if( instance == null )
		{
			throw new JObjectNotKnown( "can't delete object ["+objectHandle+"]: unknown" );
		}
		else if( instance.isOwner(lrcState.getFederateHandle()) == false )
		{
			throw new JDeletePrivilegeNotHeld( "can't delete object [" + objectHandle +
			                                   "]: delete privilege not held" );
		}
				repository.removeDiscoveredInstance( objectHandle );
				connection.broadcast( request );
		context.success();
		if( logger.isInfoEnabled() )
		{
			String timeStatus = request.isTimestamped() ? " @"+request.getTimestamp() : " (RO)";
			logger.info( "SUCCESS Deleted object ["+objectMoniker(objectHandle)+"]" + timeStatus );
		}
	}
			}