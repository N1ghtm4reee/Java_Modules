import java.util.Scanner;

public class Program {
    private static void insertTopValue(int[] topChars, int[] topCounts, int ch, int count) {
        int index = 0;

        while (index < 10) {
            if (count > topCounts[index]
                    || (count == topCounts[index] && count > 0 && ch < topChars[index])) {
                break;
            }
            index++;
        }

        if (index == 10) {
            return;
        }

        int move = 9;
        while (move > index) {
            topChars[move] = topChars[move - 1];
            topCounts[move] = topCounts[move - 1];
            move--;
        }

        topChars[index] = ch;
        topCounts[index] = count;
    }

    private static int collectTopCharacters(String text, int[] topChars, int[] topCounts) {
        int[] occurrences = new int[65536];
        char[] chars = text.toCharArray();
        int index = 0;
        int size = 0;
        int code = 0;

        while (index < chars.length) {
            occurrences[chars[index]]++;
            index++;
        }

        while (code < occurrences.length) {
            if (occurrences[code] > 0) {
                insertTopValue(topChars, topCounts, code, occurrences[code]);
            }
            code++;
        }

        while (size < 10 && topCounts[size] > 0) {
            size++;
        }
        return size;
    }

    private static int scaledHeight(int count, int maxCount) {
        return (count * 10 + maxCount - 1) / maxCount;
    }

    private static void printCell(String value) {
        int padding = 3 - value.length();

        while (padding > 0) {
            System.out.print(" ");
            padding--;
        }
        System.out.print(value);
    }

    private static void printHistogram(String text) {
        int[] topChars = new int[10];
        int[] topCounts = new int[10];
        int[] heights = new int[10];
        int size = collectTopCharacters(text, topChars, topCounts);
        int maxCount = 0;
        int index = 0;

        if (size == 0) {
            return;
        }

        while (index < size) {
            if (topCounts[index] > maxCount) {
                maxCount = topCounts[index];
            }
            index++;
        }

        index = 0;
        while (index < size) {
            heights[index] = scaledHeight(topCounts[index], maxCount);
            index++;
        }

        int level = 10;
        while (level > 0) {
            index = 0;
            while (index < size) {
                if (heights[index] == level) {
                    printCell(String.valueOf(topCounts[index]));
                } else if (heights[index] > level) {
                    printCell("#");
                } else {
                    printCell("");
                }
                index++;
            }
            System.out.println();
            level--;
        }

        index = 0;
        while (index < size) {
            printCell(String.valueOf((char) topChars[index]));
            index++;
        }
        System.out.println();
    }

    private static void runDemo() {
        String sample =
                "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAASSSSSSSSSSSSSSSSSSSSSSSDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD"
                        + "WEWWKFKKDKKDSKAKLSLDKSKALLLLLLLLLLRTRTETWTWWWWWWWWWWOOOOOOO42";
        printHistogram(sample);
        printHistogram("abcaabbccddeeff");
    }

    public static void main(String[] args) {
        if (args.length == 1 && args[0].equals("--demo")) {
            runDemo();
            return;
        }

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            printHistogram(scanner.nextLine());
        }
        scanner.close();
    }
}
