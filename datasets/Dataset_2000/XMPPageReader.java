public class XMPPageReader
{
  public List<Page> readPages(String fileName) throws FileNotFoundException, XMLStreamException
  {
    LinkedList<Page> pages = new LinkedList<Page>();
    XMLInputFactory factory = XMLInputFactory.newInstance();
    XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(fileName));
    Page curPage;
    while (true)
    {
      int event = reader.next();
      if (event == XMLStreamConstants.END_DOCUMENT) 
      {
         reader.close();
         break;
      }
      if ((event == XMLStreamConstants.START_ELEMENT) && reader.getName().toString().equals("Page"))
      {
        (curPage = new Page(reader.getAttributeValue(0))).unpersist(reader);
        pages.add(curPage);
      }
    }
    return pages;
  }
}