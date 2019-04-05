@Immutable
public class OperationParameters
{
    private final UserInformation userInformation;
    public OperationParameters ( final UserInformation userInformation )
    {
        this.userInformation = userInformation;
    }
    public UserInformation getUserInformation ()
    {
        return this.userInformation;
    }
    @Override
    public String toString ()
    {
        return "[userInformation=" + this.userInformation + "]";
    }
}