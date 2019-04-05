public class Config2 {
    private final static Logger logger = Logging.getLogger(Config2.class.getName());
    public static final int maxNodes;
    public static final int evaluatorLifeFactor;
    public static final int evaluatorPermanentFactor;
    public static final int evaluatorCreatureFactor;
    public static final int evaluatorHandFactor;
    static {
        Properties p = new Properties();
        try {
            File file = new File(Config2.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
            File propertiesFile = new File(file.getParent() + File.separator + "AIMinimax.properties");
            if (propertiesFile.exists()) {
                p.load(new FileInputStream(propertiesFile));
            } else {
                p.setProperty("maxNodes", "5000");
                p.setProperty("evaluatorLifeFactor", "2");
                p.setProperty("evaluatorPermanentFactor", "1");
                p.setProperty("evaluatorCreatureFactor", "1");
                p.setProperty("evaluatorHandFactor", "1");
            }
        } catch (IOException ex) {
            logger.log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Config2.class.getName()).log(Level.SEVERE, null, ex);
        }
        maxNodes = Integer.parseInt(p.getProperty("maxNodes"));
        evaluatorLifeFactor = Integer.parseInt(p.getProperty("evaluatorLifeFactor"));
        evaluatorPermanentFactor = Integer.parseInt(p.getProperty("evaluatorPermanentFactor"));
        evaluatorCreatureFactor = Integer.parseInt(p.getProperty("evaluatorCreatureFactor"));
        evaluatorHandFactor = Integer.parseInt(p.getProperty("evaluatorHandFactor"));
    }
}