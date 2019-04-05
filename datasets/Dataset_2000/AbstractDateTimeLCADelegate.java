abstract class AbstractDateTimeLCADelegate {
  abstract void preserveValues( DateTime dateTime );
  abstract void readData( DateTime dateTime );
  abstract void renderInitialization( DateTime dateTime ) throws IOException;
  abstract void renderChanges( DateTime dateTime ) throws IOException;
}