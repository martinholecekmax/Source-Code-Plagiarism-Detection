public class Pulsator {
  
  private static Logger log = Logger.getLogger(Pulsator.class.getName());
  
  private TimeProvider timeProvider;
  
  private PulsatorProvider pulsateProvider;
  
  public Pulsator(final Properties parameter, final TimeProvider newTimeProvider) {
    this.timeProvider = newTimeProvider;
        String pulsateType = parameter.getProperty("pulsateType", "sin");
    if (pulsateType.equals("sin")) {
      pulsateProvider = new SinusPulsator();
    } else if (pulsateType.equals("sinRaised")) {
      pulsateProvider = new SinusRaisedPulsator();
    } else if (pulsateType.equals("rectangle")) {
      pulsateProvider = new RectanglePulsator();
    } else {
      log.warning(pulsateType + " is not supported, using NullPulsater for fallback. probably not what you want...");
      pulsateProvider = new NullPulsator();
    }
        pulsateProvider.initialize(parameter);
    reset();
  }
  
  public void reset() {
    pulsateProvider.reset(timeProvider.getMsTime());
  }
  
  public float update() {
    return pulsateProvider.getValue(timeProvider.getMsTime());
  }
}