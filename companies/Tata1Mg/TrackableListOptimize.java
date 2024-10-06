package companies.mongodb;
import java.util.*;

public class TrackableListOptimize {
    private List<Integer> list;  // Stores elements in their original order
    private PriorityQueue<Integer> maxHeap; // Max heap for tracking maximum
    private PriorityQueue<Integer> minHeap; // Min heap for tracking minimum
    private Map<Integer, Integer> countMap; // Counts occurrences of each value

    public TrackableListOptimize() {
        list = new ArrayList<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
        countMap = new HashMap<>();
    }

    public void add(int value) {
        list.add(value);
        maxHeap.add(value);
        minHeap.add(value);
        countMap.put(value, countMap.getOrDefault(value, 0) + 1);
    }

    public Integer popMax() {
        while (!maxHeap.isEmpty()) {
            int maxValue = maxHeap.poll();
            if (countMap.get(maxValue) > 0) {
                countMap.put(maxValue, countMap.get(maxValue) - 1);
                list.remove((Integer) maxValue); // Remove from original list
                return maxValue;
            }
        }
        return null; // or throw an exception
    }

    public Integer popMin() {
        while (!minHeap.isEmpty()) {
            int minValue = minHeap.poll();
            if (countMap.get(minValue) > 0) {
                countMap.put(minValue, countMap.get(minValue) - 1);
                list.remove((Integer) minValue); // Remove from original list
                return minValue;
            }
        }
        return null; // or throw an exception
    }

    public List<Integer> getList() {
        return new ArrayList<>(list); // Return a copy of the list
    }

    public static void main(String[] args) {
        TrackableListOptimize trackableList = new TrackableListOptimize();
        trackableList.add(5);
        trackableList.add(3);
        trackableList.add(8);
        trackableList.add(1);

        System.out.println("Original list: " + trackableList.getList()); // [5, 3, 8, 1]

        System.out.println("Popped max: " + trackableList.popMax()); // 8
        System.out.println("Popped min: " + trackableList.popMin()); // 1

        System.out.println("Updated list: " + trackableList.getList()); // [5, 3]
    }
}

/*
Count Tracking: We use a HashMap called countMap to keep track of how many times
each value has been added. This allows us to handle duplicates without needing
to remove every occurrence from the list immediately.

Lazy Removal:
Instead of removing elements from the list immediately when popping from the heap,
we decrement the count in the countMap and only remove the element from the list
when we confirm it's the one we're popping. This avoids unnecessary removals.

Efficiency:
The average complexity for adding is still O(log n).
The pop operations involve checking the heaps, which is O(log n),
but actual list removals are only executed when needed,
making it more efficient when duplicates are present.
Behavior on Pop: If there are no valid max/min values left (due to lazy removals),
the function will continue to poll until it finds a valid entry.

This approach balances efficiency while retaining the ability to track order and
count effectively!
 */