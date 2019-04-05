public class SetSDBStruct  extends functionBase {
	private static final long serialVersionUID = 1L;
	public SetSDBStruct(){ min = 4; max = 4; 
		setNamedParams( new String[]{ "datasource", "domain", "itemname", "data" } );
	}
	public String[] getParamInfo(){
		return new String[]{
			"Amazon SimpleDB Datasource",
			"Amazon Domain to which this attribute is set",
			"The SimpleDB 'itemName' or key of the main document record",
			"data - structure"
		};
	}
	public java.util.Map getInfo(){
		return makeInfo(
				"amazon", 
				"Amazon SimpleDB: Sets all the attributes in data to the ItemName in domain", 
				ReturnType.BOOLEAN );
	}
	public cfData execute( cfSession _session, cfArgStructData argStruct ) throws cfmRunTimeException{
 		String dsName				= getNamedStringParam(argStruct, "datasource", "");
  	String domainName		= getNamedStringParam(argStruct, "domain", "");
  	String itemName			= getNamedStringParam(argStruct, "itemname", "");
  	cfData data					= getNamedParam(argStruct, "data");
  	SimpleDB	sdb = SimpleDBFactory.getDS(dsName);
  	if ( sdb == null )
  		throwException(_session, "Invalid named Amazon Datasource");
  	if ( !data.isStruct() ){
      throwException(_session, "Invalid argument. Last argument provided was not a struct.");
    }
  	cfStructData	struct = (cfStructData)data;
		HashMap map = new HashMap();
  	try {
  		  		Iterator it = struct.keySet().iterator();
  		while ( it.hasNext() ){
  			String key	= (String)it.next();
  			map.put( key, struct.getData(key).getString() );
  		}
  		  		sdb.putAttributes( domainName, itemName, map, map.keySet() );
			return cfBooleanData.TRUE;
		} catch (Exception e) {
			throwException(_session, "AmazonSimpleDB: " + e.getMessage() );
			return cfBooleanData.FALSE;
		}
  }
}