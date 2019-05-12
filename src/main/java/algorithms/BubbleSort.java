package algorithms;

public class BubbleSort {
    public static int[] bubbleSort(int[] array) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    Util.swap(array, i, i + 1);
                    isSorted = false;
                }
            }
        }

        return array;
    }
}
