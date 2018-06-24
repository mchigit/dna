package hackerrank;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RunningMedian {


    public static void addNumbers(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap, int number) {
        if (maxHeap.size() == 0 || number < maxHeap.peek()) {
            maxHeap.add(number);
        } else {
            minHeap.add(number);
        }
    }

    public static void rebalance(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        PriorityQueue<Integer> smallerHeap, biggerHeap;
        smallerHeap = maxHeap.size() > minHeap.size() ? minHeap : maxHeap;
        biggerHeap = maxHeap.size() > minHeap.size() ? maxHeap : minHeap;

        if (biggerHeap.size() - smallerHeap.size() > 1) {
            smallerHeap.add(biggerHeap.poll());
        }
    }

    public static double getMedian(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        PriorityQueue<Integer> smallerHeap, biggerHeap;
        smallerHeap = maxHeap.size() > minHeap.size() ? minHeap : maxHeap;
        biggerHeap = maxHeap.size() > minHeap.size() ? maxHeap : minHeap;
        if (smallerHeap.size() != biggerHeap.size()) {
            return biggerHeap.peek();
        } else {
            return ((double)(biggerHeap.peek() + smallerHeap.peek()))/2;
        }
    }

    public static double[] getMedians(int[] dataArray) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.<Integer>reverseOrder());

        double[] medianArray = new double[dataArray.length];

        for (int i = 0; i < dataArray.length; i++) {
            int number = dataArray[i];
            addNumbers(maxHeap, minHeap, number);
            rebalance(maxHeap, minHeap);
            double median = getMedian(maxHeap, minHeap);
            medianArray[i] = median;
        }

        return medianArray;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            int aItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            a[i] = aItem;
        }

        double[] medians = getMedians(a);

        for (int i = 0; i < medians.length; i++) {
            System.out.println(medians[i]);
        }

        scanner.close();
    }

}
