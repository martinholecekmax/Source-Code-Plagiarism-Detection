@SuppressWarnings("restriction")
public class MantisRepositoryConfiguration {
    private static final String SUPPORTS_SUBTASKS = "supports_subtasks";
    public static boolean isSupportsSubTasks(TaskRepository repository) {
        return getBooleanProperty(repository, SUPPORTS_SUBTASKS);
    }
    private static boolean getBooleanProperty(TaskRepository repository, String propertyName) {
        String property = repository.getProperty(propertyName);
        if (property == null)             return false;
        return Boolean.parseBoolean(property);
    }
    public static void setSupportsSubTasks(TaskRepository repository, boolean downloadSubTasks) {
        repository.setProperty(SUPPORTS_SUBTASKS, String.valueOf(downloadSubTasks));
    }
	
	public static boolean setCategoryIfNotSet(TaskRepository repository) {
    	String category = repository.getProperty(IRepositoryConstants.PROPERTY_CATEGORY);
    	if ( category != null)
    		return false;
    	repository.setProperty(IRepositoryConstants.PROPERTY_CATEGORY, IRepositoryConstants.CATEGORY_BUGS);
    	return true;
    }
}