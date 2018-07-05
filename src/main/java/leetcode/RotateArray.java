package leetcode;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int arraySize = nums.length;
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int newIndex = (i + k) % arraySize;
            temp[newIndex] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }
}
