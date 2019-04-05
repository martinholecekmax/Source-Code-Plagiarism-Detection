public class PanoChangeEventFormatter implements MapEventFormatter<PanoChangeMapEvent> {
  @Override
  public PanoChangeMapEvent createEvent(Properties properties) {
    return new PanoChangeMapEvent(properties);
  }
}