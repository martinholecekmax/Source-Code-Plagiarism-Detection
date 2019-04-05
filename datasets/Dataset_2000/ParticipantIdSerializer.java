public final class ParticipantIdSerializer {
  public static final Serializer<ParticipantId> INSTANCE = new Serializer<ParticipantId>() {
    @Override
    public ParticipantId fromString(String s) {
                  return s == null ? null : ParticipantId.ofUnsafe(s);
    }
    @Override
    public ParticipantId fromString(String s, ParticipantId defaultValue) {
      if (s != null) {
        return fromString(s);
      }
      return defaultValue;
    }
    @Override
    public String toString(ParticipantId x) {
      return x == null ? null : x.getAddress();
    }
  };
  private ParticipantIdSerializer() {
  }
}