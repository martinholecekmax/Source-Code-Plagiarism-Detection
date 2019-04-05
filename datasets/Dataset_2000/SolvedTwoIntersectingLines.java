public class SolvedTwoIntersectingLines extends SolvedConic {
    
    private String[] newFeatures = { "intersectionPoint", "inclination", "equationStrings" };
    
    public SolvedTwoIntersectingLines(AnalyzedEquation e) {
        super(e);
                        
        double alpha = QC.getRotation();         
        double[] coeffs = QC.getNormalizedCoefficients();
        double a = Math.sqrt(Math.abs(coeffs[0]));
        double b = Math.sqrt(Math.abs(coeffs[1]));
        PointXY intersectionPoint = new PointXY(QC.UV2XY(QC.getTranslation()));
        String[] vars = analyzedEq.getActualVariables();         double phi = 180.0 * Math.atan2(a, b) / Math.PI;
        double i1 = alpha - phi, i2 = alpha + phi;
        putNewFeatures(newFeatures);
        putFeature("graphName", "two intersecting lines");
        putFeature("intersectionPoint", intersectionPoint);
        putFeature("inclination", new NumberModel(i1));
        addToFeature("inclination", new NumberModel(i2));
        putFeature("equationStrings", QuadraticClassifier.getEquationOfALine(intersectionPoint, i1, vars));
        addToFeature("equationStrings", QuadraticClassifier.getEquationOfALine(intersectionPoint, i2, vars));
    } }