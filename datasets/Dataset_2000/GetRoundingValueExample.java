public class GetRoundingValueExample {
    public static void main(String[] args) {
        Double number = 1.5D;
                                        double roundUp = Math.ceil(number);
        System.out.println("Result of rounding up of " + number + " = " + roundUp);
                                        double roundDown = Math.floor(number);
        System.out.println("Result of rounding down of " + number + " = " + roundDown);
                                long round1 = Math.round(number);
        System.out.println("Rounding result of " + number + " (in long) =  " + round1);
                                int round2 = Math.round(number.floatValue());
        System.out.println("Rounding result of " + number + " (in int) = " + round2);
    }
}