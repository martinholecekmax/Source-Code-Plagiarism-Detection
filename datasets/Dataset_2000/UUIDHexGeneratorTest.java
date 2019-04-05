public class UUIDHexGeneratorTest extends TestCase
{
    
    public void testStringLength()
    {
        UUIDHexGenerator gen = new UUIDHexGenerator("Test", null);
        for (int i=0; i<10; i++)
        {
            Object id = gen.next();
            assertEquals(32, id.toString().length());
        }
    }
    
    public void testEquality()
    {
                String[] ids = new String[1000];
        UUIDHexGenerator gen = new UUIDHexGenerator("Test", null);
        for (int i=0;i<ids.length;i++)
        {
            ids[i] = (String)gen.next();
        }
                for (int i=0;i<ids.length;i++)
        {
            for (int j=0;j<ids.length;j++)
            {
                if (i != j)
                {
                    assertFalse("Two uuid-hex identifiers are equal yet should be unique! : " + ids[i] + " and " + ids[j], ids[i].equals(ids[j]));
                }
            }
        }
    }
}