public class StatCommandExecutor implements CommandExecutor {
    @Override
    public void execute(BinaryCommand cmd, MemcachedServer server, MemcachedConnection client) {
        String key = cmd.getKey();
        for (MemcachedServer ss : server.getBucket().activeServers()) {
            for (Entry<String, String> stat : ss.getStats().entrySet()) {
                if (key == null || key.equals(stat.getKey())) {
                    client.sendResponse(new BinaryStatResponse(cmd, stat.getKey(), stat.getValue()));
                }
            }
        }
        client.sendResponse(new BinaryResponse(cmd, ErrorCode.SUCCESS));
    }
}