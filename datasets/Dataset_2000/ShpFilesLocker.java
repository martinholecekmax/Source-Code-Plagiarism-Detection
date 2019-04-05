class ShpFilesLocker {
    final URI uri;
    final URL url;
    final FileReader reader;
    final FileWriter writer;
    boolean upgraded;
    public ShpFilesLocker( URL url, FileReader reader ) {
        this.url = url;
        this.reader = reader;
        this.writer = null;
    	        this.uri = getURI(url);
    }
    URI getURI(URL url) {
        try {
    		return url.toURI();
    	} catch (URISyntaxException e) {
    		 		}
        return null;
    }
    public ShpFilesLocker( URL url, FileWriter writer ) {
        this.url = url;
        this.reader = null;
        this.writer = writer;
    	        this.uri = getURI(url);
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((reader == null) ? 0 : reader.hashCode());
        result = prime * result + ((url == null) ? 0 : url.hashCode());
        result = prime * result + ((writer == null) ? 0 : writer.hashCode());
        return result;
    }
    @Override
    public boolean equals( Object obj ) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final ShpFilesLocker other = (ShpFilesLocker) obj;
        if (reader == null) {
            if (other.reader != null)
                return false;
        } else if (!reader.equals(other.reader))
            return false;
        if (url == null) {
            if (other.url != null)
                return false;
        } else {
        	        	if (uri != null) {
        		if (!uri.equals(other.uri))
            		return false;
        	}
        	        	else if (!url.equals(other.url))
                return false;
        }
        if (writer == null) {
            if (other.writer != null)
                return false;
        } else if (!writer.equals(other.writer))
            return false;
        return true;
    }
}