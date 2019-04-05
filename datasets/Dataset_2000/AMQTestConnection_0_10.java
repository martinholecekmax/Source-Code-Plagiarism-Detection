public class AMQTestConnection_0_10 extends AMQConnection
{
    public AMQTestConnection_0_10(String url) throws Exception
    {
        super(url);
    }
    public Connection getConnection()
    {
        return((AMQConnectionDelegate_0_10)getDelegate()).getQpidConnection();
    }    
}