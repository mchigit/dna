package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MakingAnagrams {
    // Complete the makeAnagram function below.



    static int makeAnagram(String a, String b) {
        final int asciiOffset = 97;
        int[] letters = new int[26];

        Arrays.fill(letters, 0);

        for (int i = 0; i < a.length(); i++) {
            char character = a.charAt(i);
            int index = ((int) character) - asciiOffset;
            letters[index]+= 1;
        }

        for (int i = 0; i < b.length(); i++) {
            char character = b.charAt(i);
            int index = ((int) character) - asciiOffset;
            letters[index] -= 1;
        }

        int returnNumber = 0;

        for (int i = 0; i < letters.length; i++) {
            returnNumber += Math.abs(letters[i]);
        }

        return returnNumber;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
