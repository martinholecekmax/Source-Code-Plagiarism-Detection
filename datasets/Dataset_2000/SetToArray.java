public class SetToArray {
    public static void main(String[] args) {
                                Set<Object> set = new HashSet<Object>();
        set.add("A");
        set.add(new Long(10));
        set.add(new Date());
                                                List<Object> list = new ArrayList<Object>(set);
        Object[] objects = list.toArray();
        for (int i = 0; i < objects.length; i++) {
            Object object = objects[i];
            System.out.println("Object = " + object);
        }
    }
}