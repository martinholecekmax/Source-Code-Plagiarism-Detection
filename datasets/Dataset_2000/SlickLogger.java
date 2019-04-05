public class SlickLogger {
    static private FileHandler fileTxt;
    static private SimpleFormatter formatterTxt;
    static private FileHandler fileHTML;
    static private Formatter formatterHTML;
    static private int fileSize = 1024 * 200;
    static public final Logger logger =Logger.getLogger(SlickLogger.class.getName());
    static public void setup() throws IOException {
        logger.setLevel(Level.ALL);
        fileTxt = new FileHandler("logging.txt",fileSize, 1, true);
                formatterTxt = new SimpleFormatter();
        fileTxt.setFormatter(formatterTxt);
        logger.addHandler(fileTxt);
                logger.info("Logger created");
    }
    static public String writeLog(String className, Level lvl, String text) throws IOException, MessagingException {
        String msg = "From Class: [" + className + "]\n" +text;
        logger.log(lvl, msg);
        if (lvl == Level.SEVERE){
            SlickMail.send("mychaty2@gmail.com", "SlickLogger [SEVERE] " + text);
        }
        return msg;
    }
}