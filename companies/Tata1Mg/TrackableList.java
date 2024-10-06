package companies.mongodb;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class TrackableList {
    private List<Integer> list;
    private PriorityQueue<Integer> maxHeap; // For max tracking
    private PriorityQueue<Integer> minHeap; // For min tracking

    public TrackableList() {
        list = new ArrayList<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // Max heap
        minHeap = new PriorityQueue<>(); // Min heap
    }

    public void add(int value) {
        list.add(value);
        maxHeap.add(value);
        minHeap.add(value);
    }

    public Integer popMax() {
        if (maxHeap.isEmpty()) {
            return null; // or throw an exception
        }
        int maxValue = maxHeap.poll();
        list.remove((Integer) maxValue); // Remove from the original list
        return maxValue;
    }

    public Integer popMin() {
        if (minHeap.isEmpty()) {
            return null; // or throw an exception
        }
        int minValue = minHeap.poll();
        list.remove((Integer) minValue); // Remove from the original list
        return minValue;
    }

    public List<Integer> getList() {
        return new ArrayList<>(list); // Return a copy of the list
    }

    public static void main(String[] args) {
        TrackableList trackableList = new TrackableList();
        trackableList.add(5);
        trackableList.add(3);
        trackableList.add(8);
        trackableList.add(1);

        System.out.println("Original list: " + trackableList.getList()); // [5, 3, 8, 1]

        System.out.println("Popped max: " + trackableList.popMax()); // 8
        System.out.println("Popped min: " + trackableList.popMin()); // 1

        System.out.println("Updated list: " + trackableList.getList()); // [5, 3]

        System.out.println("Popped max: " + trackableList.popMax());
    }
}

/*
Efficiency:
Adding an element is O(log n) due to the heap operations, and removing the
max or min is also O(log n). Removing from the list is O(n) in the worst case,
but this can be optimized if needed.
 */

