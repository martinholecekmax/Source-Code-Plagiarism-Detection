public interface BuildLauncher extends LongRunningOperation {
    
    BuildLauncher forTasks(String... tasks);
    
    BuildLauncher forTasks(Task... tasks);
    
    BuildLauncher forTasks(Iterable<? extends Task> tasks);
    
    BuildLauncher withArguments(String ... arguments);
    
    BuildLauncher setStandardOutput(OutputStream outputStream);
    
    BuildLauncher setStandardError(OutputStream outputStream);
    
    BuildLauncher setStandardInput(InputStream inputStream);
    
    BuildLauncher setJavaHome(File javaHome);
    
    BuildLauncher setJvmArguments(String... jvmArguments);
    
    BuildLauncher addProgressListener(ProgressListener listener);
    
    void run() throws GradleConnectionException, UnsupportedBuildArgumentException, IllegalStateException,
            BuildException, UnsupportedVersionException;
    
    void run(ResultHandler<? super Void> handler) throws IllegalStateException;
}