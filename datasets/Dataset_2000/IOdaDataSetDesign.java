public interface IOdaDataSetDesign extends IBaseDataSetDesign, ICacheable
{
    
    public abstract String getQueryText();
    
    public abstract String getExtensionID();
    
    public abstract String getPrimaryResultSetName();
    
	public abstract Map getPublicProperties( );   
    
	public abstract Map getPrivateProperties( );   
	
	public abstract int getPrimaryResultSetNumber( );
}