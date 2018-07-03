package algorithms;

public class Sort {

    public static void bubbleSort(int[] array) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    isSorted = false;
                }
            }
        }
    }

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left >= right) return;
        int pivot = array[(left + right) / 2];
        int index = partition(array, left, right, pivot);
        quickSort(array, left, index - 1);
        quickSort(array, index, right);
    }

    public static void mergeSort(int[] array) {
        mergeSort(array, new int[array.length], 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int[] temp, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(array, temp, left, middle);
            mergeSort(array, temp, middle + 1, right);
            merge(array, temp, left, right);
        }
    }

    private static void merge(int[] array, int[] temp, int left, int right) {
        //initializing bounds and pointers
        int leftEnd = (left + right) / 2;
        int rightStart = leftEnd + 1;
        int size = right - left + 1;

        int leftPointer = left;
        int rightPointer = rightStart;
        int index = left;

        while (leftPointer <= leftEnd && rightPointer <= right) {
            if (array[leftPointer] < array[rightPointer]) {
                temp[index] = array[leftPointer];
                leftPointer++;
            } else {
                temp[index] = array[rightPointer];
                rightPointer++;
            }
            index++;
        }

        System.arraycopy(array, leftPointer, temp, index, leftEnd - leftPointer + 1);
        System.arraycopy(array, rightPointer, temp, index, right - rightPointer + 1);
        System.arraycopy(temp, left, array, left, size);
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
                swap(array, left, right);
                left++;
                right--;
            }
        }

        return left;
    }

    public static void swap (int[] array, int i , int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
