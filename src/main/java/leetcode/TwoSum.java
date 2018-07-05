package leetcode;

import java.util.HashMap;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> numbers = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            int complement = target - number;
            if (numbers.containsKey(complement)) {
                int index = numbers.get(complement);
                int smallerIndex = i < index ? i : index;
                int biggerIndex = i < index ? index : i;
                result[0] = smallerIndex;
                result[1] = biggerIndex;
                break;
            } else {
                numbers.put(number, i);
            }
        }

        return result;
    }
}
