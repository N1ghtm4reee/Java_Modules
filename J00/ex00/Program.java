package ex00; // not important for now

public class Program {

    private static final int NUMBER = 479598;

    public static void main(String[] args) {
        int number = NUMBER;
        int result = 0;

        while (number != 0) {
            result += number % 10;
            number /= 10;
        }

        System.out.print(result + "\n");
    }
}
