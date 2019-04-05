public class GaussianCDF extends Gaussian implements ProbabilityDistribution {
    
    public GaussianCDF() {
    	super();
    }
    
    public GaussianCDF(double mu, double s) {
    	super(mu,s);
    }
    public String getDescription() {
        return "Gaussian cumulative probability density function";
    }
    public void precompute(double startValue, double endValue, int nBins) {
        if (startValue >= endValue) {
                        return;
        }
        precomputeFrom = startValue;
        precomputeTo = endValue;
        numberOfBins = nBins;
        double div = (endValue - startValue) / (double) nBins;
        histogram = new double[nBins];
        for (int i = 0; i < nBins; i ++) {
            double x = startValue + i * div;
                                    histogram[i] = bigPhi(x, mean, sigma);
        }
        precomputed = true;
    }
    public double getProbability(double x) {
        return bigPhi(x, mean, sigma);
    }
}