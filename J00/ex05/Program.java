import java.util.Scanner;

public class Program {
    static int toInt(String s) {
        int n = 0;
        char[] c = s.toCharArray();
        int i = 0;

        while (i < c.length) {
            n = n * 10 + c[i] - '0';
            i++;
        }
        return n;
    }

    static int dayIndex(String day) {
        if (day.equals("MO")) return 0;
        if (day.equals("TU")) return 1;
        if (day.equals("WE")) return 2;
        if (day.equals("TH")) return 3;
        if (day.equals("FR")) return 4;
        if (day.equals("SA")) return 5;
        return 6;
    }

    static int firstDate(int day) {
        int[] dates = {7, 1, 2, 3, 4, 5, 6};
        return dates[day];
    }

    static int findStudent(String[] students, int count, String name) {
        int i = 0;

        while (i < count) {
            if (students[i].equals(name)) return i;
            i++;
        }
        return -1;
    }

    static void sortColumns(int[] dates, int[] times, int[] days, int count) {
        int i = 0;
        int j;
        int tmp;

        while (i < count) {
            j = i + 1;
            while (j < count) {
                if (dates[i] > dates[j]
                        || (dates[i] == dates[j] && times[i] > times[j])) {
                    tmp = dates[i];
                    dates[i] = dates[j];
                    dates[j] = tmp;
                    tmp = times[i];
                    times[i] = times[j];
                    times[j] = tmp;
                    tmp = days[i];
                    days[i] = days[j];
                    days[j] = tmp;
                }
                j++;
            }
            i++;
        }
    }

    static void printCell(String text, int width) {
        int i = 0;

        while (i < width - text.length()) {
            System.out.print(" ");
            i++;
        }
        System.out.print(text);
        System.out.print("|");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] students = new String[10];
        int[] classTimes = new int[10];
        int[] classDays = new int[10];
        String[] dayNames = {"MO", "TU", "WE", "TH", "FR", "SA", "SU"};
        int[][] attendance = new int[10][50];
        int[] dates = new int[50];
        int[] times = new int[50];
        int[] days = new int[50];
        String[] labels = new String[50];
        int studentCount = 0;
        int classCount = 0;
        int columnCount = 0;
        int nameWidth = 0;
        String token;
        int i;
        int j;

        while (scanner.hasNext()) {
            token = scanner.next();
            if (token.equals(".")) break;
            students[studentCount] = token;
            if (token.length() > nameWidth) nameWidth = token.length();
            studentCount++;
        }
        while (scanner.hasNext()) {
            token = scanner.next();
            if (token.equals(".")) break;
            classTimes[classCount] = toInt(token);
            classDays[classCount] = dayIndex(scanner.next());
            classCount++;
        }
        i = 0;
        while (i < classCount) {
            j = firstDate(classDays[i]);
            while (j <= 30) {
                dates[columnCount] = j;
                times[columnCount] = classTimes[i];
                days[columnCount] = classDays[i];
                columnCount++;
                j += 7;
            }
            i++;
        }
        sortColumns(dates, times, days, columnCount);
        i = 0;
        while (i < columnCount) {
            labels[i] = times[i] + ":00 " + dayNames[days[i]] + " " + dates[i];
            i++;
        }
        while (scanner.hasNext()) {
            token = scanner.next();
            if (token.equals(".")) break;
            i = findStudent(students, studentCount, token);
            j = 0;
            int time = toInt(scanner.next());
            int date = toInt(scanner.next());
            String status = scanner.next();

            while (j < columnCount) {
                if (times[j] == time && dates[j] == date) {
                    if (status.equals("HERE")) attendance[i][j] = 1;
                    else attendance[i][j] = -1;
                    break;
                }
                j++;
            }
        }
        i = 0;
        while (i < nameWidth + 1) {
            System.out.print(" ");
            i++;
        }
        i = 0;
        while (i < columnCount) {
            System.out.print(labels[i] + "|");
            i++;
        }
        System.out.println();
        i = 0;
        while (i < studentCount) {
            System.out.print(students[i]);
            j = students[i].length();
            while (j < nameWidth + 1) {
                System.out.print(" ");
                j++;
            }
            System.out.print("|");
            j = 0;
            while (j < columnCount) {
                if (attendance[i][j] == 1) printCell("1", labels[j].length());
                else if (attendance[i][j] == -1) printCell("-1", labels[j].length());
                else printCell("", labels[j].length());
                j++;
            }
            System.out.println();
            i++;
        }
        scanner.close();
    }
}
