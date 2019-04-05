public class ImplicitResultSetProxyHandler extends AbstractResultSetProxyHandler {
	private ConnectionProxyHandler connectionProxyHandler;
	private Connection connectionProxy;
	private Statement sourceStatement;
	public ImplicitResultSetProxyHandler(ResultSet resultSet, ConnectionProxyHandler connectionProxyHandler, Connection connectionProxy) {
		super( resultSet );
		this.connectionProxyHandler = connectionProxyHandler;
		this.connectionProxy = connectionProxy;
	}
	public ImplicitResultSetProxyHandler(ResultSet resultSet, ConnectionProxyHandler connectionProxyHandler, Connection connectionProxy, Statement sourceStatement) {
		super( resultSet );
		this.connectionProxyHandler = connectionProxyHandler;
		this.connectionProxy = connectionProxy;
		this.sourceStatement = sourceStatement;
	}
	@Override
	protected JdbcServices getJdbcServices() {
		return connectionProxyHandler.getJdbcServices();
	}
	@Override
	protected JdbcResourceRegistry getResourceRegistry() {
		return connectionProxyHandler.getResourceRegistry();
	}
	@Override
	protected Statement getExposableStatement() {
		if ( sourceStatement == null ) {
			try {
				Statement stmnt = getResultSet().getStatement();
				if ( stmnt == null ) {
					return null;
				}
				sourceStatement = ProxyBuilder.buildImplicitStatement( stmnt, connectionProxyHandler, connectionProxy );
			}
			catch ( SQLException e ) {
				throw getJdbcServices().getSqlExceptionHelper().convert( e, e.getMessage() );
			}
		}
		return sourceStatement;
	}
	protected void invalidateHandle() {
		sourceStatement = null;
		super.invalidateHandle();
	}
}