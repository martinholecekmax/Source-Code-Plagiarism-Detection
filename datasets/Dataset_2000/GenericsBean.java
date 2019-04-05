public class GenericsBean {
   private List<GenericsInternalBean> genericsInternalBeanList;
   private List noTypeList;
   private ArrayList<String> stringArrayList;
   private HashSet<String> stringHashSet;
   private List<String> stringList;
   private Set<String> stringSet;
   public List<GenericsInternalBean> getGenericsInternalBeanList() {
      return genericsInternalBeanList;
   }
   public List getNoTypeList() {
      return noTypeList;
   }
   public ArrayList<String> getStringArrayList() {
      return stringArrayList;
   }
   public HashSet<String> getStringHashSet() {
      return stringHashSet;
   }
   public List<String> getStringList() {
      return stringList;
   }
   public Set<String> getStringSet() {
      return stringSet;
   }
   public void setGenericsInternalBeanList( List<GenericsInternalBean> genericsInternalBeanList ) {
      this.genericsInternalBeanList = genericsInternalBeanList;
   }
   public void setNoTypeList( List noTypeList ) {
      this.noTypeList = noTypeList;
   }
   public void setStringArrayList( ArrayList<String> stringArrayList ) {
      this.stringArrayList = stringArrayList;
   }
   public void setStringHashSet( HashSet<String> stringHashSet ) {
      this.stringHashSet = stringHashSet;
   }
   public void setStringList( List<String> stringList ) {
      this.stringList = stringList;
   }
   public void setStringSet( Set<String> stringSet ) {
      this.stringSet = stringSet;
   }
   public static class GenericsInternalBean {
      private String string;
      public String getString() {
         return string;
      }
      public void setString( String string ) {
         this.string = string;
      }
   }
}