public class Rfc822ByteArrayNonAsciiTestCase extends Rfc822ByteArrayTestCase 
{
    @Override
    protected MimeMessage newMimeMessage() throws MessagingException
    {
        MimeMessage message = new MimeMessage(newSession());
        String text = LocaleMessageHandler.getString("test-data", Locale.JAPAN, 
            "Rfc822ByteArrayNonAsciiTestCase.newMimeMessage", new Object[] {});
        message.setText(text, "iso-2022-jp");
        message.setSubject(text, "iso-2022-jp");
        message.setFrom(new InternetAddress("bob@example.com"));
        return message;
    }
}