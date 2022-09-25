package array;

import java.util.*;

//Print the elements of an array in the decreasing frequency if 2 numbers
// have the same frequency then print the one which came first
public class SortByFrequency {
    public static void main(String[] args) {
        Integer arr[] = {2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8};
        List<Integer> list = Arrays.asList(arr);
        sortByFrequency(list);
    }

    public static void sortByFrequency(List<Integer> list) { //T -> O(nlogn) and S -> O(n)
        int n = list.size();
        final HashMap<Integer, Integer> mapCount = new HashMap<>();
        final HashMap<Integer, Integer> mapIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = list.get(i);
            if (mapCount.containsKey(num)) {
                mapCount.put(num, mapCount.get(num) + 1);
            } else {
                mapCount.put(num, 1);
                mapIndex.put(num, i); //Map to capture 1st occurrence of elements
            }
        }
        //Comparator interface overriding compare method
        Collections.sort(list, (n1, n2) -> {
            int freqn1 = mapCount.get(n1);
            int freqn2 = mapCount.get(n2);
            if (freqn1 != freqn2) {
                return freqn2 - freqn1;
            } else {
                return mapIndex.get(n1) - mapIndex.get(n2); // Elements with Lesser Index gets Higher Priority
            }
        });
        System.out.println(list);
    }
}
