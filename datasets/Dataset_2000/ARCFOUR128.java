public class ARCFOUR128 implements Cipher {
    private static final int ivsize = 8;
    private static final int bsize = 16;
    private static final int skip = 1536; 
    private javax.crypto.Cipher cipher;    
    public int getIVSize() {
        return ivsize;
    } 
    public int getBlockSize() {
        return bsize;
    }
    public void init(int mode, byte[] key, byte[] iv) throws Exception {
        byte[] tmp;
        if (key.length > bsize) {
            tmp = new byte[bsize];
            System.arraycopy(key, 0, tmp, 0, tmp.length);
            key = tmp;
        }
        try {
            cipher = javax.crypto.Cipher.getInstance("RC4");
            SecretKeySpec _key = new SecretKeySpec(key, "RC4");
            cipher.init(
                    (mode == ENCRYPT_MODE
                            ? javax.crypto.Cipher.ENCRYPT_MODE
                            : javax.crypto.Cipher.DECRYPT_MODE),
                            _key);
            byte[] foo = new byte[1];
            for (int i = 0; i < skip; i++) {
                cipher.update(foo, 0, 1, foo, 0);
            }
        } catch (Exception e) {
            cipher = null;
            throw e;
        }
    }
    public void update(byte[] foo, int s1, int len, byte[] bar, int s2) throws Exception {
        cipher.update(foo, s1, len, bar, s2);
    }
    public boolean isCBC() {
        return false;
    }
}