package dailyCodingProblems;

import java.util.Hashtable;


/*
Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 */

public class Day1 {
    private static Boolean twoSum(int[] input, int sum) {
        Hashtable<Integer, Integer> inputHolder = new Hashtable<Integer, Integer>();
        for (int i = 0; i < input.length; i++) {
            // check if hash table has a key with corresponding value equal to input[i]
            if (inputHolder.containsValue(input[i])) {
                return true;
            }
            inputHolder.put(input[i], sum - input[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] testArray = {10, 15, 3, 7};
        System.out.println(twoSum(testArray, 17));
    }
}
