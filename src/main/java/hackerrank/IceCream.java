package hackerrank;

import java.util.HashMap;
import java.util.Scanner;

public class IceCream {

    /*
    This is basically the 2 sum problem.
    Given an array of int, which are the prices of each flavour, and a sum, which is the total money they have
    print out the elements in the array that adds up to it.
    Can use binary search, loop through each element in the array, and search for another element that makes up the sum
     */

    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
        HashMap<Integer, Integer> pairs = new HashMap<>();

        for (int i = 0; i < cost.length; i++) {
            int compliment = money - cost[i];
            int element = cost[i];
            if (pairs.containsKey(compliment)) {
                int compIndex = pairs.get(compliment) + 1;
                int eleIndex = i + 1;
                String result = eleIndex < compIndex ? eleIndex + " " + compIndex : compIndex + " " + eleIndex;
                System.out.println(result);
                break;
            } else {
                pairs.put(element, i);
            }
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }

        scanner.close();
    }
}