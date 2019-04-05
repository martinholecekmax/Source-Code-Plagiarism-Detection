public class Scrub {
  
    private static boolean enableScrubbing = false;
  public static void setEnableScrubbing(final boolean enableScrubbing) {
    Scrub.enableScrubbing = enableScrubbing;
  }
  
  public static final String REFERRER_SCRUBBING_URL =
      "http:  
  public static String scrub(String url) {
    if (enableScrubbing) {
      if (url.startsWith("#") || url.startsWith(REFERRER_SCRUBBING_URL)) {
                        return url;
      } else {
        String x = REFERRER_SCRUBBING_URL + URL.encodeComponent(url);
        return x;
      }
    } else {
                  String sanitizedUri = EscapeUtils.sanitizeUri(url);
      return sanitizedUri;
    }
  }
}