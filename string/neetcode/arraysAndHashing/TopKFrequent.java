package neetcode.arraysAndHashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TopKFrequent {
    public static void main(String[] args) {
        int[] nums = {1, 1,4, 1, 2, 2,4, 3,4};
        int[] result = topKFrequent(nums,2);
        for(int x : result){
            System.out.print(x+", ");
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int result[] = new int[k];
        int index = 0;
        ArrayList<Integer> bucket[] = new ArrayList[nums.length + 1];
        Map<Integer, Integer> frequency_map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (frequency_map.containsKey(nums[i])) {
                frequency_map.put(nums[i], frequency_map.get(nums[i]) + 1);
            } else {
                frequency_map.put(nums[i], 1);
            }
        }

        for (Map.Entry<Integer,Integer> mapElement : frequency_map.entrySet()) {
            int key = mapElement.getKey();
            if(bucket[mapElement.getValue()] == null){
                bucket[mapElement.getValue()] = new ArrayList<>();
            }
            bucket[mapElement.getValue()].add(key);
        }

        for (int i = bucket.length - 1; i > 0 && index < result.length; i--) {
            if(bucket[i] == null){
                continue;
            }else{
                int size = bucket[i].size();
                for(int j=0; j<size && j < k;j++){
                    result[index++] = bucket[i].get(j);
                }
            }
        }
        return result;
    }
}
