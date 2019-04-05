public class PackageWordDetector implements IWordDetector {
	public boolean isWordPart(char c) {
		return Character.isLetterOrDigit(c) || (c == '-') || (c == '_') || (c == '+');
	}
	public boolean isWordStart(char c) {
		return (c == ' ') || (c == ',') || (c == '\t') || (c == ':');
	}
}