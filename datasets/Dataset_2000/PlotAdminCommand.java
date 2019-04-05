public class PlotAdminCommand extends IClaimsCommand
{
	InfiniteClaims			plugin;
	InfiniteClaimsUtilities	icUtils;
	public PlotAdminCommand(InfiniteClaims plugin)
	{
		super(plugin);
		this.plugin = plugin;
		this.icUtils = plugin.getIcUtils();
		this.setName("Plot Administration");
		this.setCommandUsage(String.format("%s/iclaims admin %s{remove,reset,addmember,removemember...} ...", ChatColor.YELLOW, ChatColor.RED));
		this.setArgRange(2, 3);
		this.addKey("iclaims admin");
		this.addKey("iclaimsadmin");
		this.addKey("icadmin");
		Map<String, Boolean> children = new HashMap<String, Boolean>();
		children.put("iclaims.admin.remove", true);
		children.put("iclaims.admin.reset", true);
		children.put("iclaims.admin.addmember", true);
		children.put("iclaims.admin.removemember", true);
		children.put("iclaims.admin.info", true);
		Permission admin = new Permission("iclaims.admin", "Administrate players plot.", PermissionDefault.OP);
		this.setPermission(admin);
		this.addCommandExample(String.format("%s/iclaims admin addmember %s?", ChatColor.YELLOW, ChatColor.RED));
		this.addCommandExample(String.format("%s/iclaims admin remove %s?", ChatColor.YELLOW, ChatColor.RED));
		this.addCommandExample(String.format("%s/iclaims admin removemember %s?", ChatColor.YELLOW, ChatColor.RED));
		this.addCommandExample(String.format("%s/iclaims admin info %s?", ChatColor.YELLOW, ChatColor.RED));
	}
	public void runCommand(CommandSender sender, List<String> args)
	{
	}
}