public class ARCReaderFactoryTest extends TmpDirTestCase {
    
    public void testGetFileURL() throws MalformedURLException, IOException {
        File arc = ARCWriterTest.createARCFile(getTmpDir(), true);
        doGetFileUrl(arc);
    }
    protected void doGetFileUrl(File arc)
    throws MalformedURLException, IOException {
        ARCReader reader = null;
        File tmpFile = null;
        try {
            reader = ARCReaderFactory.
                get(new URL("file:            tmpFile = null;
            for (Iterator<ArchiveRecord> i = reader.iterator(); i.hasNext();) {
                ARCRecord r = (ARCRecord)i.next();
                if (tmpFile == null) {
                    tmpFile = new File(r.getMetaData().getArc());
                }
            }
            assertTrue(tmpFile.exists());
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        assertTrue(tmpFile.exists());
    }
    
    public void testGetPathOrURL() throws MalformedURLException, IOException {
        File arc = ARCWriterTest.createARCFile(getTmpDir(), true);
        ARCReader reader = ARCReaderFactory.get(arc.getAbsoluteFile());
        assertNotNull(reader);
        reader.close();
        doGetFileUrl(arc);
    }   
}