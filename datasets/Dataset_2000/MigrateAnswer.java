public class MigrateAnswer extends Answer {
    Integer vncPort = null;
    protected MigrateAnswer() {
    }
    public MigrateAnswer(MigrateCommand cmd, boolean result, String detail, Integer vncPort) {
        super(cmd, result, detail);
        this.vncPort = vncPort;
    }
    public Integer getVncPort() {
        return vncPort;
    }
}