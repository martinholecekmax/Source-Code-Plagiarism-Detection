public class GenericKarafPlatformModelFactory implements KarafPlatformModelFactory {
    private static final GenericKarafPlatformValidator platformValidator =
        new GenericKarafPlatformValidator();
    @Override
    public KarafPlatformModel getPlatformModel(final IPath rootDirectory) {
        if (!platformValidator.isValid(rootDirectory)) {
        }
        return new GenericKarafPlatformModel(rootDirectory);
    }
    @Override
    public KarafPlatformValidator getPlatformValidator() {
        return platformValidator;
    }
}