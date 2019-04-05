public class CipherHttpTest extends AbstractHDIVTestCase {
	private static Log log = LogFactory.getLog(CipherHttpTest.class);
	private ICipherHTTP cipherHttp;
	private IKeyFactory keyFactory;
	private Key key;
	
	protected void onSetUp() throws Exception {
		this.cipherHttp = (ICipherHTTP) this.getApplicationContext().getBean("cipher");
		this.keyFactory = (IKeyFactory) this.getApplicationContext().getBean("keyFactory");
		this.key = this.keyFactory.generateKey();
	}
	public void testEncrypt() throws Exception {
		String data = "Data to encrypt";
		this.cipherHttp.initEncryptMode(key);
		String encryptedData = new String(this.cipherHttp.encrypt(data.getBytes())); 
		this.cipherHttp.initDecryptMode(key);
		String clearData= new String (this.cipherHttp.decrypt(encryptedData.getBytes()));
		assertTrue(clearData.equalsIgnoreCase(data));		
	}
}