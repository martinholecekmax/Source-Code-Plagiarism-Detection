public class XorAlgorithmSpecification extends ClassicAlgorithmSpecification {
	@Override
	public boolean isValidPlainTextAlphabet(AbstractAlphabet alpha) {
		return alpha.getName().toLowerCase().contains("xor");
	}
	public char[] keyInputStringToDataobjectFormat(String keyInput) {
		return keyInput == null ? "".toCharArray() : keyInput.toCharArray();
	}
	
	public List<KeyVerificator> getKeyFileVerificators() {
		List<KeyVerificator> verificators = new LinkedList<KeyVerificator>();
		verificators.add(new KeyVerificator() {
			@Override
			protected boolean verifyKeyInput(String key, AbstractAlphabet alphabet) {
				File f = new File(key);
				return f.exists();
			}
			@Override
			protected InputVerificationResult getFailResult(String key,
					AbstractAlphabet alphabet) {
				return new InputVerificationResult() {
					public boolean isValid() {
						return false;
					}
					public boolean isStandaloneMessage() {
						return true;
					}
					public MessageType getMessageType() {
						return InputVerificationResult.MessageType.ERROR;
					}
					public String getMessage() {
						return "The key file does not exist.";
					}
				};
			}
		});
		return verificators;
	}
	@Override
	public boolean isAllowCustomAlphabetCreation() {
		return false;
	}
}