public class StatsCommand extends CommandHandler {
    private static HashMap eligibleChunksForSpawning = new HashMap();
    public StatsCommand(OldMcDonald plugin){
        super(plugin);
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!sender.hasPermission("oldmcdonald.stats")) return true;
        plugin.spawner.displayReport();
        return true;
        
    }
}