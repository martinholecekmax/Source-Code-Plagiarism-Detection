public class IphoneBuildAndUnitTest extends AbstractActionType{
    private static final String NAME = "xcodebuild";
    private String type;
    public String getName() {
        return NAME;
    }
    public StringBuilder getCommand() {
        return new StringBuilder(FrameworkConstants.MVN_IPHONE_NATIVE_UNITTEST);
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}