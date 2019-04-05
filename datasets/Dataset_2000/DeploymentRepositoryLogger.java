@MessageLogger(projectCode = "JBAS")
interface DeploymentRepositoryLogger extends BasicLogger {
    
    DeploymentRepositoryLogger ROOT_LOGGER = Logger.getMessageLogger(DeploymentRepositoryLogger.class, DeploymentRepositoryLogger.class.getPackage().getName());
    
    @LogMessage(level = INFO)
    @Message(id = 14900, value = "Content added at location %s")
    void contentAdded(String path);
    @LogMessage(level = INFO)
    @Message(id = 14901, value = "Content removed from location %s")
    void contentRemoved(String path);
}