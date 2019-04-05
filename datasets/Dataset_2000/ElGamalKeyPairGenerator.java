public class ElGamalKeyPairGenerator
    implements AsymmetricCipherKeyPairGenerator
{
    private ElGamalKeyGenerationParameters param;
    public void init(
        KeyGenerationParameters param)
    {
        this.param = (ElGamalKeyGenerationParameters)param;
    }
    public AsymmetricCipherKeyPair generateKeyPair()
    {
        BigInteger           p, g, x, y;
        int                  qLength = param.getStrength() - 1;
        ElGamalParameters    elParams = param.getParameters();
        p = elParams.getP();
        g = elParams.getG();
                        		x = new BigInteger(qLength, param.getRandom());
                                y = g.modPow(x, p);
        return new AsymmetricCipherKeyPair(
                new ElGamalPublicKeyParameters(y, elParams),
                new ElGamalPrivateKeyParameters(x, elParams));
    }
}