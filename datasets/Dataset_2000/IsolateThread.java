public final class IsolateThread extends Thread {
    private final VmIsolate isolate;
    private final PluginManager piManager;
    private final PrintStream stdout;
    private final PrintStream stderr;
    private final InputStream stdin;
    
    IsolateThread(ThreadGroup group, VmIsolate isolate,
                  PluginManager piManager, PrintStream stdout, PrintStream stderr,
                  InputStream stdin) {
        super(group, null, isolate.getMainClassName(), isolate
            .getIsolatedStaticsTable());
        this.isolate = isolate;
        this.piManager = piManager;
        this.stdout = stdout;
        this.stderr = stderr;
        this.stdin = stdin;
                System.setIn(stdin);
        System.setOut(stdout);
        System.setErr(stderr);
    }
    
    @Override
    public final void run() {
        isolate.run(this);
    }
    
    final PluginManager getPluginManager() {
        return piManager;
    }
    
    final PrintStream getStderr() {
        return stderr;
    }
    
    final InputStream getStdin() {
        return stdin;
    }
    
    final PrintStream getStdout() {
        return stdout;
    }
}