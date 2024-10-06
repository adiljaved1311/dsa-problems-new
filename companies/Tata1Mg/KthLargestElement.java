package companies.mongodb;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 6, 4, 8};
        System.out.println(kthLargestElement(arr, 3));
        System.out.println(kthSmallestElement(arr,3));
    }

    // for finding kth largest element
    private static int kthLargestElement(int[] arr, int k) {
        // Min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (pq.peek() < arr[i]) {
                pq.remove();
                pq.add(arr[i]);
            }
        }
        return pq.peek();
    }

    // for finding kth smallest element
    private static int kthSmallestElement(int[] arr, int k) {
        // max heap
        // by default, it is implemented as min heap, to implement it as max heap we need to pass a comparator in args as below
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if(pq.peek() > arr[i]){
                pq.remove();
                pq.add(arr[i]);
            }
        }
        return pq.peek();
    }
}
