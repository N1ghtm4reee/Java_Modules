public class Program {
    private static final int NUMBER = 479598;

    private static int sumDigits(int number) {
        int value = number;
        int sum = 0;

        while (value != 0) {
            sum += value % 10;
            value /= 10;
        }
        return sum;
    }

    private static void runDemo() {
        System.out.println("479598 -> " + sumDigits(479598));
        System.out.println("111111 -> " + sumDigits(111111));
        System.out.println("900000 -> " + sumDigits(900000));
        System.out.println("123456 -> " + sumDigits(123456));
    }

    public static void main(String[] args) {
        if (args.length == 1 && args[0].equals("--demo")) {
            runDemo();
            return;
        }
        System.out.println(sumDigits(NUMBER));
    }
}
