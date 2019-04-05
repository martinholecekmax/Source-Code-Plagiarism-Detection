public class JpegFileFilter extends FileFilter{
    
    public JpegFileFilter() {
    }
    public boolean accept(File f) {
        if( AcceptableExtension(f) || f.isDirectory()==true)
            return true;
        return false;        
    }
    public String getExtension(File f) {
        String ext = null;
        String name = f.getName();
        int offset = name.lastIndexOf('.');
        if (offset > 0 &&  offset < name.length() - 1) {
            ext = name.substring(offset+1).toLowerCase();
        }
        return ext;
    }
    public boolean AcceptableExtension(File f){
        String extension = getExtension(f);
        if ( extension != null )
            if ( extension.equals("bmp") || extension.equals("dib") )
                return true;
        return false;
    }
        public String getDescription() {
        return "Formato JPEG File Interchange (*.jpg; *.jpeg; *.jpe; *.jfif)";
    }
    public String toString(){
        return "jpg";
    }
}