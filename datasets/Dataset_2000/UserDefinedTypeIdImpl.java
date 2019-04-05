public class UserDefinedTypeIdImpl extends BaseTypeIdImpl
{
	
	protected String className;
	
	public	UserDefinedTypeIdImpl() { super(); }
	
	public UserDefinedTypeIdImpl(String className) throws StandardException
	{
                                        if ( className.charAt( 0 ) == '"' )
        {
            String[] nameParts = IdUtil.parseMultiPartSQLIdentifier( className );
            schemaName = nameParts[ 0 ];
            unqualifiedName = nameParts[ 1 ];
            className = null;
        }
        else
        {
            schemaName = null;
            unqualifiedName = className;
            this.className = className;
        }
        JDBCTypeId = java.sql.Types.JAVA_OBJECT;
	}
	
	public UserDefinedTypeIdImpl(String schemaName, String unqualifiedName, String className)
	{
		super( schemaName, unqualifiedName );
		this.className = className;
		JDBCTypeId = java.sql.Types.JAVA_OBJECT;
	}
	
	public String	getClassName()
	{
		return className;
	}
	
	public boolean userType()
	{
		return true;
	}
	
	public boolean isBound() { return !(className == null); }
		
	public void readExternal( ObjectInput in )
		 throws IOException, ClassNotFoundException
	{
		super.readExternal( in );
		className = in.readUTF();
		JDBCTypeId = java.sql.Types.JAVA_OBJECT;
	}
	
	public void writeExternal( ObjectOutput out )
		 throws IOException
	{
		super.writeExternal( out );
                        if ( className == null )
        {
            throw new IOException( "Internal error: class name for user defined type has not been determined yet." );
        }
		out.writeUTF( className );
	}
	
	public	int	getTypeFormatId()	{ return StoredFormatIds.USERDEFINED_TYPE_ID_IMPL_V3; }
}