class BAMHeaderReader {
    private final File file;
    private HashMap<String, Integer> chromosomeIndex;
    private HashMap<String, Integer> chromosomeLength;
    BAMHeaderReader(File file) {
        this.file = file;
    }
    public int getChromosomeIndex(String name) {
        if (chromosomeIndex == null) {
            try {
                readInfo();
            } catch (IOException e) {
                return -1;
            }
        }
        Integer index = chromosomeIndex.get(name);
        return index != null ? index : -1;
    }
        public int getChromosomeLength(String name) {
        if (chromosomeLength == null) {
            try {
                readInfo();
            } catch (IOException e) {
                return -1;
            }
        }
        Integer length = chromosomeLength.get(name);
        return length != null ? length : -1;
    }
    private void readInfo() throws IOException {
        chromosomeIndex = new HashMap<String, Integer>();
        chromosomeLength = new HashMap<String, Integer>();
        InputStream stream = null;
        try {
            stream = new GZIPInputStream(new FileInputStream(file));
            if (!"BAM\001".equals(FileTools.readString(stream, 4))) {
                throw new BAMException("Invalid BAM file signature");
            }
            final int l_text = FileTools.readInt32(stream);
            FileTools.readString(stream, l_text);
            final int n_ref = FileTools.readInt32(stream);
            for (int i = 0; i < n_ref; ++i) {
                final int l_name = FileTools.readInt32(stream);
                final String name = l_name > 0 ? FileTools.readString(stream, l_name).substring(0, l_name - 1) : "";
                final int l_ref = FileTools.readInt32(stream);
                chromosomeIndex.put(name, i);
                chromosomeLength.put(name, l_ref);
            }
        } finally {
            closeQuietly(stream);
        }
    }
}