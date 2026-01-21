package ex01;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int iterations = 1;
        int div = 2;
        boolean result = true;

        if (number <= 1) {
            System.err.print("IllegalArgument\n");
            System.exit(-1);
        }

        while (true) {
            if (number % div == 0) {
                result = false;
                break;
            }
            if (div >= (number / 2)) {
                break;
            }
            iterations++;
            div += 1;
        }

        System.out.print(result + " " + iterations + "\n");
        scanner.close();
    }
}
