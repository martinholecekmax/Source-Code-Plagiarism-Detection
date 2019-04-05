public class SceneGraphFileWriter extends java.lang.Object {
    private RandomAccessFileControl fileControl;
    private File file;
    
    public SceneGraphFileWriter( java.io.File file,
                       SimpleUniverse universe,
                       boolean writeUniverseContent,
                       String fileDescription,
                       java.io.Serializable fileUserData) throws IOException, UnsupportedUniverseException {
        fileControl = new RandomAccessFileControl();
        this.file = file;
        file.createNewFile();
        if (!file.canWrite())
            throw new IOException( "Can not Write to File" );
        fileControl.createFile( file, universe, writeUniverseContent, fileDescription, fileUserData );
    }
    
    public void writeBranchGraph( BranchGroup graph ) throws IOException {
        writeBranchGraph( graph, null );
    }
    
    public void writeBranchGraph( BranchGroup graph,
                                  java.io.Serializable data ) throws IOException {
        fileControl.writeBranchGraph( graph, data );
    }
    
    public void addObjectName( String name, SceneGraphObject object ) throws NamedObjectException {
        fileControl.addNamedObject( name, object );
    }
    
    public void close() throws IOException {
        fileControl.close();
    }
}