package algorithms;

public class MergeSort {
    public static int[] mergeSort(int[] input) {
        if (input.length <= 1) return input;


        //initializing 2 lists
        int middle = input.length /2;
        int[] leftList = new int[middle];
        int[] rightList = new int[input.length - leftList.length];

        System.arraycopy(input, 0, leftList, 0, leftList.length);
        System.arraycopy(input, middle, rightList, 0, rightList.length);

        mergeSort(leftList);
        mergeSort(rightList);

        mergeArray(leftList, rightList, input);
        return input;
    }

    private static void mergeArray(int[] left, int[] right, int[] input) {
        int leftIndex = 0;
        int rightIndex = 0;
        int copiedArrayIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                input[copiedArrayIndex] = left[leftIndex];
                leftIndex++;
            } else {
                input[copiedArrayIndex] = right[rightIndex];
                rightIndex++;
            }
            copiedArrayIndex++;
        }

        //copy over the remaining
        System.arraycopy(left, leftIndex, input, copiedArrayIndex, left.length - leftIndex);
        System.arraycopy(right, rightIndex, input, copiedArrayIndex, right.length - rightIndex);
    }
}
