package hackerrank;

import java.util.HashMap;
import java.util.Scanner;

public class RansomNote {
    static void checkMagazine(String[] magazine, String[] note) {
        boolean canForm = true;

        HashMap<String, Integer> words = new HashMap<String, Integer>();

        for (int i = 0; i < magazine.length; i++) {
            String word = magazine[i];
            if (words.containsKey(word)) {
                words.replace(word, words.get(word) + 1);
            } else {
                words.put(word, 1);
            }
        }

        for (int i = 0; i < note.length; i++) {
            String word = note[i];
            if (words.containsKey(word)) {
                words.replace(word, words.get(word) - 1);
                if (words.get(word) < 0) {
                    canForm = false;
                    break;
                }
            } else {
                canForm = false;
                break;
            }
        }

        System.out.println(canForm ? "Yes" : "No");

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
