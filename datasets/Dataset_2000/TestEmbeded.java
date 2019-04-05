public class TestEmbeded extends TestCase
{
	public void testExcel() throws Exception {
		POIXMLDocument doc = new XSSFWorkbook(
                POIDataSamples.getSpreadSheetInstance().openResourceAsStream("ExcelWithAttachments.xlsm")
        );
		test(doc, 4);
	}
	public void testWord() throws Exception {
		POIXMLDocument doc = new XWPFDocument(
                POIDataSamples.getDocumentInstance().openResourceAsStream("WordWithAttachments.docx")
        );
		test(doc, 5);
	}
	public void testPowerPoint() throws Exception {
		POIXMLDocument doc = new XSLFSlideShow(OPCPackage.open(
                POIDataSamples.getSlideShowInstance().openResourceAsStream("PPTWithAttachments.pptm"))
        );
		test(doc, 4);
	}
	private void test(POIXMLDocument doc, int expectedCount) throws Exception {
		assertNotNull(doc.getAllEmbedds());
		assertEquals(expectedCount, doc.getAllEmbedds().size());
		for(int i=0; i<doc.getAllEmbedds().size(); i++) {
			PackagePart pp = doc.getAllEmbedds().get(i);
			assertNotNull(pp);
			byte[] b = IOUtils.toByteArray(pp.getInputStream());
			assertTrue(b.length > 0);
		}
	}
}