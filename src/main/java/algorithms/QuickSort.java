package algorithms;

public class QuickSort {

    public static int[] quickSort(int[] array) {
        return quickSort(array, 0, array.length - 1);
    }

    private static int[] quickSort(int[] array, int left, int right) {
        if (left >= right) return array;
        int pivot = array[(left + right) / 2];
        int index = partition(array, left, right, pivot);
        quickSort(array, left, index - 1);
        quickSort(array, index, right);
        return array;
    }




    private static int partition(int[] array, int left, int right, int pivot) {
        while (left <= right) {
            while (array[left] < pivot) {
                left++;
            }

            while (array[right] > pivot) {
                right--;
            }

            if (left <= right) {
                Util.swap(array, left, right);
                left++;
                right--;
            }
        }

        return left;
    }
}
