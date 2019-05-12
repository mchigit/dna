package algorithms;

public class SelectionSort {
    public static int[] SelectionSort(int[] input) {
        int swapIndex = 0;
        while (swapIndex < input.length) {
            int smallestInt = Integer.MAX_VALUE;
            int smallestIndex = 0;
            for (int i = swapIndex; i < input.length; i++) {
                if (input[i] < smallestInt) {
                    smallestInt = input[i];
                    smallestIndex = i;
                }
            }
            Util.swap(input, swapIndex, smallestIndex);
            swapIndex++;
        }

        return input;
    }
}
