import java.util.Scanner;

public class Program {
    private static void printPrimeStatus(int number, boolean exitOnError) {
        int div = 2;
        int iterations = 1;

        if (number <= 1) {
            System.err.println("IllegalArgument");
            if (exitOnError) {
                System.exit(-1);
            }
            return;
        }
        while (div <= number / div) {
            if (number % div == 0) {
                System.out.println("false " + iterations);
                return;
            }
            div++;
            iterations++;
        }
        System.out.println("true " + iterations);
    }

    private static void runDemo() {
        printPrimeStatus(169, false);
        printPrimeStatus(113, false);
        printPrimeStatus(42, false);
        printPrimeStatus(-100, false);
    }

    public static void main(String[] args) {
        if (args.length == 1 && args[0].equals("--demo")) {
            runDemo();
            return;
        }

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            printPrimeStatus(scanner.nextInt(), true);
        }
        scanner.close();
    }
}
