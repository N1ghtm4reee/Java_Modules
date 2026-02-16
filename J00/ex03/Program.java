/*

 * Program
 * 
 * Version information
 *
 * Date
 * 
 * Copyright notice
 */

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Program {

    // vars needed
    static Map<Integer, int[]> studentData = new TreeMap<>();
    static int weekNumber = 0;

    static void visualizeData() {
        studentData.forEach((key, val) -> {
            System.out.print("Week " + key + " ");
            calculateAverage(val);
        });
    }

    static void calculateAverage(int[] notes) {
        // calculates average & visualize progress
        int avg = 0;
        for (int i = 0; i < notes.length; i++) {
            avg += notes[i];
        }
        avg /= notes.length;
        while(--avg != 0) {
            System.out.print('=');
        }
        System.out.println(">");
    }

    static void parser(String input) {
        if (input.startsWith("Week")) /* */
        {
            int thisWeekNumber = Integer.parseInt(input.split(" ")[1]);
            if ((thisWeekNumber > 0 && thisWeekNumber <= 18) && (thisWeekNumber - weekNumber == 1)) /* weeks from 1 to 18 and ensure order*/
            {
                weekNumber = thisWeekNumber;
            }
            else /* Invalid input */
            {
                throw new IllegalArgumentException();
            }
        }
        else if (!input.startsWith("Week")) {
            int[] intNotes = new int[5];
            String[] strNotes = input.split(" ");
            if (strNotes.length != 5) throw new IllegalArgumentException();
            for (int i = 0; i < 5; i++) {
                int note = Integer.parseInt(strNotes[i]);
                if (!(note > 0 && note < 10)) throw new IllegalArgumentException();
                intNotes[i] = note;
            }
            studentData.put(weekNumber, intNotes);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            while(scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                if (line.equals("42")) { /* reached limit */
                    break;
                }
                parser(line);
            }
            visualizeData();
            scanner.close();
        } catch (Exception e) {
            System.err.println("Invalid input");
        }
    }
}