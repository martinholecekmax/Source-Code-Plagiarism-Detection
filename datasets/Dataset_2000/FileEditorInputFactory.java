public class FileEditorInputFactory implements IElementFactory {
    
    private static final String ID_FACTORY = "org.eclipse.ui.part.FileEditorInputFactory";     
    private static final String TAG_PATH = "path";     
    public FileEditorInputFactory() {
    }
    
    public IAdaptable createElement(IMemento memento) {
                String fileName = memento.getString(TAG_PATH);
        if (fileName == null) {
			return null;
		}
                        IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(
                new Path(fileName));
        if (file != null) {
			return new FileEditorInput(file);
		}
		return null;
    }
    
    public static String getFactoryId() {
        return ID_FACTORY;
    }
    
    public static void saveState(IMemento memento, FileEditorInput input) {
        IFile file = input.getFile();
        memento.putString(TAG_PATH, file.getFullPath().toString());
    }
}