public class CMSFormatter extends BaseFormatter implements Formatter
{
    public CMSFormatter(X509Certificate certificate, PrivateKey privateKey, Provider provider)
            throws SignatureException
    {
        super(certificate, privateKey, provider);
    }
    @Override
    public SignatureResult format(SignatureOptions signatureOptions) throws SignatureException
    {
        checkSignatureOptions(signatureOptions);
        byte[] data = StreamUtils.inputStreamToByteArray(signatureOptions.getDataToSign());
        try
        {
            MyCMSSignedDataGenerator formatter = new MyCMSSignedDataGenerator();
            formatter.addSigner(privateKey, certificate, CMSSignedGenerator.DIGEST_SHA1);
            formatter.addCertificatesAndCRLs(generateCertificateStore());
            if (signatureOptions.isHash())
            {
                formatter.setHash(data);
            }
            CMSProcessableByteArray cmsProcessableByteArray = new CMSProcessableByteArray(data);
            CMSSignedData cmsSignedData = formatter.generate(cmsProcessableByteArray, provider);
            SignatureResult signatureResult = new SignatureResult(true);
            signatureResult.setSignatureData(new ByteArrayInputStream(cmsSignedData.getEncoded()));
            return signatureResult;
        }
        catch (Exception e)
        {
            throw new SignatureException(e);
        }
    }
    private CertStore generateCertificateStore() throws InvalidAlgorithmParameterException,
            NoSuchAlgorithmException
    {
        List<Certificate> certList = Arrays.asList((Certificate) certificate);
        CertStore certst = CertStore.getInstance("Collection", new CollectionCertStoreParameters(
                certList));
        return certst;
    }
}