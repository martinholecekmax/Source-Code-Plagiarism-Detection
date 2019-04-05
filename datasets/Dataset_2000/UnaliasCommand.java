public class UnaliasCommand
	extends AbstractCommand
{
	public UnaliasCommand()
	{
		this.usage = " <word> - remove a CLI abbreviation.";
	}
	@Override
	public void run( final String cmd, final String parameters )
	{
		Aliases.remove( parameters );
	}
}