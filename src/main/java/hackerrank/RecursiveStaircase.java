package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RecursiveStaircase {

    // Complete the stepPerms function below.
    /*
    There are multiple ways of completing this task. Can use memoization, or dynamic programming
     */
    private static final long modulo = 10000000007L;

    static int stepPerms(int n) {
        return stepPermsMemo(n, new int[n + 1]);
    }

    private static int stepPermsMemo(int n, int[] memo) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        }

        if (memo[n] == 0) {
            memo[n] = stepPermsMemo(n - 1, memo) + stepPermsMemo(n - 2, memo) + stepPermsMemo(n - 3, memo);
        }

        return (int)(memo[n] % modulo);
    }

    //I think the DP version is easier to understand
    private static int stepPermsDP(int n) {
        if (n < 0) return 0;
        if (n == 0 || n == 1) return 1;

        int[] paths = new int[n + 1];
        paths[0] = 1;
        paths[1] = 1;
        paths[2] = 2;

        for (int i = 3; i <= n; i++) {
            paths[i] = paths[i - 1] + paths[i - 2] + paths[i - 3];
        }

        return (int)(paths[n] % modulo);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int s = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int sItr = 0; sItr < s; sItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int res = stepPerms(n);

            bufferedWriter.write(String.valueOf(res));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
