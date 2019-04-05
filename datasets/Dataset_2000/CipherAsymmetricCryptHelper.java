public class CipherAsymmetricCryptHelper extends CipherHelper<KeyPair> {
    private static final String plainData = "some data to encrypt and decrypt test";
    public CipherAsymmetricCryptHelper(String algorithmName) {
        super(algorithmName, plainData, Cipher.ENCRYPT_MODE,
                Cipher.DECRYPT_MODE);
    }
    public void test(KeyPair keyPair) {
        test(keyPair.getPrivate(), keyPair.getPublic());
    }
}