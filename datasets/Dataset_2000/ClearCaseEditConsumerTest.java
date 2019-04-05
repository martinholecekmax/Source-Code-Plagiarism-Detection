public class ClearCaseEditConsumerTest
    extends ScmTestCase
{
    public void testConsumer()
        throws IOException
    {
        InputStream inputStream = getResourceAsStream( "/clearcase/edit/edit.txt" );
        BufferedReader in = new BufferedReader( new InputStreamReader( inputStream ) );
        String s = in.readLine();
        ClearCaseEditConsumer consumer = new ClearCaseEditConsumer( new DefaultLog() );
        while ( s != null )
        {
            consumer.consumeLine( s );
            s = in.readLine();
        }
        Collection<ScmFile> entries = consumer.getEditFiles();
        assertEquals( "Wrong number of entries returned", 1, entries.size() );
        ScmFile scmFile = (ScmFile) entries.iterator().next();
        assertEquals( "test.java", scmFile.getPath() );
        assertEquals( ScmFileStatus.EDITED, scmFile.getStatus() );
    }
}