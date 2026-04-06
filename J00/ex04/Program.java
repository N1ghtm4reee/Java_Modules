package ex04;

import java.util.*;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] counts = new int[26];
        int[] top = new int[10];
        Arrays.fill(top, -1);

        try {
            if (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                for (char c : line.toCharArray()) {
                    if (!Character.isAlphabetic(c)) {
                        throw new Exception("Invalid input");
                    }
                    c = Character.toLowerCase(c);
                    int idx = c - 'a';
                    counts[idx]++;
                    updateTop(top, counts, idx);
                }
            }

            List<Integer> used = new ArrayList<>();
            for (int i : top) {
                if (i != -1 && counts[i] > 0 && !used.contains(i)) {
                    used.add(i);
                }
            }
            if (used.isEmpty()) {
                return;
            }

            used.sort((a, b) -> {
                if (counts[b] != counts[a]) return counts[b] - counts[a];
                return a - b;
            });

            int maxCount = 0;
            for (int i : used) {
                maxCount = Math.max(maxCount, counts[i]);
            }

            int[] scaled = new int[used.size()];
            for (int i = 0; i < used.size(); i++) {
                int cnt = counts[used.get(i)];

                scaled[i] = (cnt * 10 + maxCount - 1) / maxCount; // ceil(cnt * 10 / maxCount)
                if (scaled[i] == 0) scaled[i] = 1; // just in case
            }

            int maxHeight = 10;

            for (int level = maxHeight; level >= 1; level--) {
                StringBuilder row = new StringBuilder();
                for (int i = 0; i < used.size(); i++) {
                    int cnt = counts[used.get(i)];
                    int h   = scaled[i];

                    if (h >= level) {
                        if (level == h) {
                            row.append(cnt);
                        } else {
                            row.append("#");
                        }
                    } else {
                        row.append(" ");
                    }

                    if (i != used.size() - 1) {
                        row.append(" ");
                    }
                }
                System.out.println(row.toString().replaceFirst("\\s+$", ""));
            }

            StringBuilder lettersLine = new StringBuilder();
            for (int i = 0; i < used.size(); i++) {
                char ch = (char) ('A' + used.get(i));
                lettersLine.append(ch);
                if (i != used.size() - 1) {
                    lettersLine.append(" ");
                }
            }
            System.out.println(lettersLine);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static void updateTop(int[] top, int[] counts, int idx) {
        int pos = -1;

        // already in top?
        for (int i = 0; i < top.length; i++) {
            if (top[i] == idx) {
                pos = i;
                break;
            }
        }

        // not present: try to add in empty slot
        if (pos == -1) {
            for (int i = 0; i < top.length; i++) {
                if (top[i] == -1) {
                    top[i] = idx;
                    pos = i;
                    break;
                }
            }
        }

        // still not present: maybe replace the smallest
        if (pos == -1) {
            int minPos = 0;
            for (int i = 1; i < top.length; i++) {
                if (counts[top[i]] < counts[top[minPos]]) {
                    minPos = i;
                }
            }
            if (counts[idx] > counts[top[minPos]]) {
                top[minPos] = idx;
                pos = minPos;
            } else {
                return; // does not enter top10
            }
        }

        // bubble up by (count desc, letter asc)
        while (pos > 0) {
            int cur  = top[pos];
            int prev = top[pos - 1];
            if (prev == -1) {
                top[pos - 1] = cur;
                top[pos] = -1;
                pos--;
            } else if (counts[cur] > counts[prev] ||
                    (counts[cur] == counts[prev] && cur < prev)) {
                top[pos] = prev;
                top[pos - 1] = cur;
                pos--;
            } else {
                break;
            }
        }
    }
}
