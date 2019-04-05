public class OnFlyContents {
    public static void main(String args[]) throws Exception {
        LocalSpace myLocalSpace = new LocalSpace(null);
        JavaSpace05 mySpace = (JavaSpace05) myLocalSpace.getJavaSpaceProxy();
        Collection myTemplates =
            Collections.singletonList(new Contents05Entry());
        mySpace.write(new Contents05Entry("55"), null, Lease.FOREVER);
        MatchSet mySet = mySpace.contents(myTemplates, null, Lease.FOREVER,
            5);
        for (int i = 1; i < 11; i++) {
            mySpace.write(new Contents05Entry(Integer.toString(i)), null, Lease.FOREVER);
        }
        Entry myResult;
        Thread.sleep(10000);
        while ((myResult = mySet.next()) != null) {
            System.out.println("Read: " + myResult);
        }
        Thread.sleep(10000);
        while ((myResult = mySpace.take(new Contents05Entry(), null, 0))
            != null) {
            System.out.println("Took: " + myResult);
        }
        System.out.println("Cancel lease");
        mySet.getLease().cancel();
        myLocalSpace.stop();
    }
    public static final class Contents05Entry implements Entry {
        public String _field;
        public Contents05Entry() {
        }
        Contents05Entry(String aValue) {
            _field = aValue;
        }
        public String toString() {
            return _field;
        }
    }
}