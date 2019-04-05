public class Sterea extends Lon0FromCentralMeridianParams {
    private Double k;
    public Sterea() {
        super();
        setType(ProjType.STEREA);
    }
    public Sterea(Lon0FromCentralMeridianParams projectedCommonParams,
                  Double k) {
        super(projectedCommonParams);
        setType(ProjType.STEREA);
        this.k = k;
    }
    @Override
    protected String getProj4StringRest() {
        String rv = " +lat_0=" + DoubleVal.format(getLat0());
        rv = rv + " +lon_0=" + DoubleVal.format(getLon0());
        if (k != null) rv = rv + " +k=" + DoubleVal.format(k);
        rv = rv + super.getProj4StringRest();
        return rv;
    }
    @Override
    public void initFromProj4String(Map<String, String> proj4StringVals) {
        if (proj4StringVals.containsKey("k")) {
            k = Double.parseDouble(proj4StringVals.get("k"));
        }
        super.initFromProj4String(proj4StringVals);
    }
    @Override
    protected void initFromCrs(ProjectedCRS crs, String origText, Projection pr) throws ConversionException {
        super.initFromCrs(crs, origText, pr);
        k = null;
        try {
            k = pr.getParameterValues().parameter("scale_factor").doubleValue();
            if (eq(k, 1.0) && !origText.contains("scale_factor")) {
                k = null;
            }
        }
        catch (Exception ignore) {
        }
    }
}