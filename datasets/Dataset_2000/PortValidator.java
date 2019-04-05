public class PortValidator implements Validator
{
    public boolean validate(ProcessingClient client)
    {
        InetAddress inet = null;
        String host = "localhost";
        boolean retValue = false;
        int numfields = client.getNumFields();
        for (int i = 0; i < numfields; i++)
        {
            String value = client.getFieldContents(i);
            if ((value == null) || (value.length() == 0))
            {
                return false;
            }
            try
            {
                inet = InetAddress.getByName(host);
                ServerSocket socket = new ServerSocket(Integer.parseInt(value), 0, inet);
                retValue = socket.getLocalPort() > 0;
                if (!retValue)
                {
                    break;
                }
                socket.close();
            }
            catch (Exception ex)
            {
                retValue = false;
            }
        }
        return retValue;
    }
}