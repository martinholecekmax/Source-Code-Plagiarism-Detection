public class ADJCommandExecutor implements CommandExecutor
{
	private List<BaseCommand> commands = new ArrayList<BaseCommand>();
	public ADJCommandExecutor() 
	{		
				commands.add(new HelpCommand());
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
				if (args.length == 0) {
			args = new String[]{"help"};
		}
				BaseCommand onCmd;
		BaseCommand[] onCmdArray = commands.toArray(new BaseCommand[0]);
		int index = 0;
		String[] tempArgs = args;
		while (index < onCmdArray.length && tempArgs.length > 0)
		{
			onCmd = onCmdArray[index];
			if(tempArgs[0].equalsIgnoreCase(onCmd.name))
			{
				if(onCmd.subCommands.size() > 0 && tempArgs.length > 1)
				{
					onCmdArray = onCmd.subCommands.toArray(new BaseCommand[0]);
					index = 0;
					tempArgs = (String[]) ArrayUtils.remove(tempArgs, 0);
				} else {
					tempArgs = (String[]) ArrayUtils.remove(tempArgs, 0);
					return onCmd.newInstance().run(sender, tempArgs, label);
				}
			} else {
				index++;
			}
		}
		new HelpCommand().run(sender, args, label);
		return true;
	}
	
	public List<BaseCommand> getCommands()
	{
		return commands;
	}
}