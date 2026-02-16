/*

 * Program
 *
*/

package ex02;import java.util.Scanner;

public class Program {

    static int sumOfElements(int number) {
        int result = 0;
        
        while (number != 0) {
            result += number % 10;
            number /= 10;
        }

        return result;
    }

    static boolean isPrime(int number) {
        int div = 2;
        if (number < 2) return false;

        while (div <= (number / 2)) {
            if (number % div == 0) {
                return false;
            }
            div++;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queries = 1;
        int count = 0;
        try{
            while (!scanner.hasNextInt()) {
                int number = scanner.nextInt();

                int sum = sumOfElements(number);
                if (isPrime(sum) == true) {
                    count++;
                }
                if (queries % 4 == 0) {
                    System.out.print("Count of coffee-request : " + count + "\n");
                }
                queries++;
            }
            scanner.close();
        }
        catch(Exception e) {
            System.exit(1);
        }
    }    
}
