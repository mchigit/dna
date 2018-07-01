package hackerrank;

import java.util.Scanner;


//this is basically implementing bubble sort

public class BubbleSort {

    public static int bubbleSort(int[] array, int count) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    count++;
                    isSorted = false;
                }
            }
        }

        return count;
    }

    public static void swap (int[] array, int i , int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Complete the countSwaps function below.
    static void countSwaps(int[] a) {
        int count = 0;

        System.out.println("Array is sorted in " + bubbleSort(a, count) +" swaps.");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        countSwaps(a);

        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[a.length - 1]);
        scanner.close();
    }
}
