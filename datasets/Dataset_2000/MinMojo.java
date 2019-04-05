public final class MinMojo extends AbstractMojo {
    
    private String targetDirName = "";
    
    private String cssSourceDir;
    
    private String cssTargetDir;
    
    private String jsSourceDir;
    
    private String jsTargetDir;
    
    private List<String> adminJSs = new ArrayList<String>();
    
    private String suffix = "";
        @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        final ExecutorService executor = Executors.newFixedThreadPool(2);
        final Future<?> processCSSFilesTask =
                executor.submit(new CSSProcessor(getLog(),
                                                 cssSourceDir,
                                                 cssTargetDir
                                                 + targetDirName, suffix));
        final Future<?> processJSFilesTask =
                executor.submit(new JSProcessor(getLog(),
                                                jsSourceDir,
                                                jsTargetDir
                                                + targetDirName,
                                                suffix, adminJSs));
        try {
            if (processCSSFilesTask != null) {
                processCSSFilesTask.get();
            }
            if (processJSFilesTask != null) {
                processJSFilesTask.get();
            }
        } catch (final Exception e) {
            getLog().error(e.getMessage(), e);
        }
    }
}