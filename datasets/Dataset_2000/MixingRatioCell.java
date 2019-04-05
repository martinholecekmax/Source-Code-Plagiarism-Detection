public final class MixingRatioCell extends ComputeCell {
    
    private static final Real noData;
    static {
        try {
            noData = (Real) WaterVaporMixingRatio.getRealType().missingData();
        } catch (Exception ex) {
            System.err.println("Couldn't initialize class");
            ex.printStackTrace();
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    public MixingRatioCell(DataReference dewRef, DataReference presRef)
            throws VisADException, RemoteException {
        super("MixingRatioCell", new DataReference[]{ dewRef, presRef },
              noData);
        enableAllInputRefs();
    }
    
    protected Data compute(Data[] datums)
            throws TypeException, VisADException, RemoteException {
        Real dew   = (Real) datums[0];
        Real pres  = (Real) datums[1];
        Real ratio = noData;
        if ((pres != null) && (dew != null)) {
            Util.vetType(AirPressure.getRealType(), pres);
            Util.vetType(DewPoint.getRealType(), dew);
            ratio = (Real) WaterVaporMixingRatio.create(pres, dew);
        }
        return ratio;
    }
}