public class RebuildListener implements PropertyChangeListener {
    @Override
	public void propertyChange(PropertyChangeEvent event) {
    	boolean doTouch = false;
    	boolean updateProjectPaths = shouldUpdatePaths(event);
        if (updateProjectPaths) {
            Object source = event.getSource();
            if (source instanceof MoSyncProject) {
                MoSyncProject project = (MoSyncProject) source;
                            	                ICProject cProject = CoreModel.getDefault().create(project.getWrappedProject());
                try {
					MoSyncPathInitializer.getInstance().initialize(MoSyncIncludePathContainer.CONTAINER_ID, cProject);
				} catch (CoreException e) {
					CoreMoSyncPlugin.getDefault().log(e);
				}
                IProfile profile = project.getTargetProfile();
                doTouch = profile != null;
            }
        } else if (MoSyncProject.BUILD_CONFIGURATION_CHANGED == event.getPropertyName()) {
        	doTouch = true;
        }
        if (doTouch) {
                        Object source = event.getSource();
            if (source instanceof MoSyncProject) {
                try {
                    ((MoSyncProject) source).getWrappedProject().touch(null);
                } catch (CoreException e) {
                    CoreMoSyncPlugin.getDefault().log(e);
                }
            }
        }
    }
	private boolean shouldUpdatePaths(PropertyChangeEvent event) {
		return MoSyncProject.TARGET_PROFILE_CHANGED == event.getPropertyName() ||
				MoSyncBuilder.ADDITIONAL_INCLUDE_PATHS.equals(NameSpacePropertyOwner.getKey(event.getPropertyName())) ||
				MoSyncBuilder.IGNORE_DEFAULT_INCLUDE_PATHS.equals(NameSpacePropertyOwner.getKey(event.getPropertyName()));
	}
}