public class Amf0ValueTest {
    @Test
    public void testEncodeAndDecodeDate() {
        ChannelBuffer out = ChannelBuffers.dynamicBuffer();
        Date date = new Date();
        Amf0Value.encode(out, date);
        Date test = (Date) Amf0Value.decode(out);
        assertEquals(date, test);
    }
}