package algorithms;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SortTest {
    private int[] randomInt = new int[] {1,3,0,0,-312, 3, 999999, -12321, 123, 4, 12, 41, 123};

    @Test
    public void SelectionSort() {
        SelectionSort sort = new SelectionSort();
        int[] sorted = sort.SelectionSort(randomInt);
        for (int i = 0; i < sorted.length - 1; i++) {
            assertTrue(sorted[i] <= sorted[i + 1]);
        }
    }

    @Test
    public void QuickSort() {
        QuickSort sort = new QuickSort();
        int[] sorted = sort.quickSort(randomInt);
        for (int i = 0; i < sorted.length - 1; i++) {
            assertTrue(sorted[i] <= sorted[i + 1]);
        }
    }

    @Test
    public void BubbleSort() {
        BubbleSort sort = new BubbleSort();
        int[] sorted = sort.bubbleSort(randomInt);
        for (int i = 0; i < sorted.length - 1; i++) {
            assertTrue(sorted[i] <= sorted[i + 1]);
        }
    }

    @Test
    public void MergeSort() {
        MergeSort sort = new MergeSort();
        int[] sorted = sort.mergeSort(randomInt);
        for (int i = 0; i < sorted.length - 1; i++) {
            assertTrue(sorted[i] <= sorted[i + 1]);
        }
    }
}
