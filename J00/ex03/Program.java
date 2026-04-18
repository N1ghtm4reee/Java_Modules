import java.util.Scanner;

public class Program {
    private static void fail(boolean exitOnError) {
        System.err.println("IllegalArgument");
        if (exitOnError) {
            System.exit(-1);
        }
    }

    private static boolean processStatistics(Scanner scanner, boolean exitOnError) {
        long statistics = 0;
        int weekCount = 0;

        while (scanner.hasNext()) {
            String token = scanner.next();

            if (token.equals("42")) {
                printStatistics(statistics, weekCount);
                return true;
            }
            if (!token.equals("Week") || !scanner.hasNextInt()) {
                fail(exitOnError);
                return false;
            }

            int week = scanner.nextInt();
            int test = 0;
            int minGrade = 10;

            if (week != weekCount + 1 || week > 18) {
                fail(exitOnError);
                return false;
            }

            while (test < 5) {
                if (!scanner.hasNextInt()) {
                    fail(exitOnError);
                    return false;
                }

                int grade = scanner.nextInt();
                if (grade < 1 || grade > 9) {
                    fail(exitOnError);
                    return false;
                }
                if (grade < minGrade) {
                    minGrade = grade;
                }
                test++;
            }

            statistics = statistics * 10 + minGrade;
            weekCount++;
        }

        fail(exitOnError);
        return false;
    }

    private static void printStatistics(long statistics, int weekCount) {
        long divisor = 1;
        int week = 1;

        while (week < weekCount) {
            divisor *= 10;
            week++;
        }

        week = 1;
        while (week <= weekCount) {
            int minGrade = (int) ((statistics / divisor) % 10);
            int bar = 0;

            System.out.print("Week " + week + " ");
            while (bar < minGrade) {
                System.out.print("=");
                bar++;
            }
            System.out.println(">");

            if (divisor > 1) {
                divisor /= 10;
            }
            week++;
        }
    }

    private static void runDemo() {
        printStatistics(2634, 4);
        fail(false);
    }

    public static void main(String[] args) {
        if (args.length == 1 && args[0].equals("--demo")) {
            runDemo();
            return;
        }

        Scanner scanner = new Scanner(System.in);
        processStatistics(scanner, true);
        scanner.close();
    }
}
