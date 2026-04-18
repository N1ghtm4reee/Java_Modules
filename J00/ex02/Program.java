import java.util.Scanner;

public class Program {
    private static int sumDigits(int number) {
        int value = number;
        int sum = 0;

        while (value != 0) {
            sum += value % 10;
            value /= 10;
        }
        return sum;
    }

    private static boolean isPrime(int number) {
        int div = 2;

        if (number <= 1) {
            return false;
        }
        while (div <= number / div) {
            if (number % div == 0) {
                return false;
            }
            div++;
        }
        return true;
    }

    private static void processSequence(Scanner scanner) {
        int count = 0;

        while (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            if (number == 42) {
                break;
            }
            if (isPrime(sumDigits(number))) {
                count++;
            }
        }
        System.out.println("Count of coffee-request : " + count);
    }

    private static void runDemo() {
        int count = 0;

        if (isPrime(sumDigits(198131))) {
            count++;
        }
        if (isPrime(sumDigits(12901212))) {
            count++;
        }
        if (isPrime(sumDigits(11122))) {
            count++;
        }
        System.out.println("Count of coffee-request : " + count);

        count = 0;
        if (isPrime(sumDigits(2))) {
            count++;
        }
        if (isPrime(sumDigits(3))) {
            count++;
        }
        if (isPrime(sumDigits(5))) {
            count++;
        }
        System.out.println("Count of coffee-request : " + count);
    }

    public static void main(String[] args) {
        if (args.length == 1 && args[0].equals("--demo")) {
            runDemo();
            return;
        }

        Scanner scanner = new Scanner(System.in);
        processSequence(scanner);
        scanner.close();
    }
}
