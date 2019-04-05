public abstract class GPFitnessFunction
    implements java.io.Serializable {
  
  private final static String CVS_REVISION = "$Revision: 1.11 $";
  public final static double NO_FITNESS_VALUE = -1.0000000d;
  public final static double MAX_FITNESS_VALUE = Double.MAX_VALUE / 2;
  private transient static Logger LOGGER = Logger.getLogger(GPFitnessFunction.class);
  
  private double m_lastComputedFitnessValue = NO_FITNESS_VALUE;
  
  public void GPFitnessFunction() {
  }
  
  public final double getFitnessValue(final IGPProgram a_program) {
                    double fitnessValue;
    try {
      fitnessValue = evaluate(a_program);
    } catch (IllegalStateException iex) {
      LOGGER.debug(iex.getMessage());
      fitnessValue = NO_FITNESS_VALUE;
      return fitnessValue;
    }
    if (fitnessValue < 0.00000000d) {
      throw new RuntimeException(
          "Fitness values must be positive! Received value: "
          + fitnessValue);
    }
    m_lastComputedFitnessValue = fitnessValue;
    return fitnessValue;
  }
  
  public double getLastComputedFitnessValue() {
    return m_lastComputedFitnessValue;
  }
  
  protected abstract double evaluate(IGPProgram a_subject);
}