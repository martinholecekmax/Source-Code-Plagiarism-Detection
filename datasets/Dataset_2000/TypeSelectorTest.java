public class TypeSelectorTest extends BaseSelectorTest {
    public TypeSelectorTest(String name) {
        super(name);
    }
    
    public BaseSelector getInstance() {
        return new TypeSelector();
    }
    
    public void testValidate() {
        TypeSelector s = (TypeSelector)getInstance();
        try {
            s.isSelected(basedir,filenames[0],files[0]);
            fail("TypeSelector did not check for required fields");
        } catch (BuildException be1) {
            assertEquals("The type attribute is required"
                    , be1.getMessage());
        }
    }
    
    public void testSelectionBehaviour() {
        TypeSelector s;
        String results;
        TypeSelector.FileType directory = new
                TypeSelector.FileType();
        directory.setValue("dir");
        TypeSelector.FileType file = new
                TypeSelector.FileType();
        file.setValue("file");
        try {
            makeBed();
            s = (TypeSelector)getInstance();
            s.setType(directory);
            results = selectionString(s);
            assertEquals("TFFFFFFFFFFT", results);
            s = (TypeSelector)getInstance();
            s.setType(file);
            results = selectionString(s);
            assertEquals("FTTTTTTTTTTF", results);
        }
        finally {
            cleanupBed();
        }
    }
}