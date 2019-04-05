class SourceNameComparator implements Comparator<Member>, Serializable {
  public int compare(Member o1, Member o2) {
    return o1.getSourceName().compareTo(o2.getSourceName());
  }
  
  private Object readResolve() {
    return Member.SOURCE_NAME_COMPARATOR;
  }
}