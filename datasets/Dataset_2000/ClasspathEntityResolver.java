public class ClassPathEntityResolver implements EntityResolver
{		
	public InputSource resolveEntity(String publicId, String systemId)	
	{
		try
		{
			URI uri=new URI(systemId);
			if(uri.getScheme().equals("classpath"))
			{				
				String path=uri.getPath();
								path=path.substring(1);
				Logger.getLogger(ClassPathEntityResolver.class.getName()).fine("resolve "+systemId+" from CLASSPATH at "+path);
				InputStream in= ClassLoader.getSystemResourceAsStream(path);
				if(in==null)
					return new InputSource(new StringReader(""));
				return new InputSource(in);
			}
			return null;
		}
		catch(URISyntaxException ex)
		{
			ex.printStackTrace();
			return null;
		}
	}	
}