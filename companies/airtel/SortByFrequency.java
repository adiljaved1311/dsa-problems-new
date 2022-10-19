package companies.airtel;

import java.util.*;

//Print the elements of an array in the decreasing frequency if 2 numbers
// have the same frequency then print the one which came first
public class SortByFrequency {
    public static void main(String[] args) {
        Integer arr[] = {2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8};
        List<Integer> list = Arrays.asList(arr);
        sortByFrequency(list);
        System.out.println(list);
    }

    private static void sortByFrequency(List<Integer> list) {
        HashMap<Integer,Integer> freqn_count = new HashMap<>();
        final HashMap<Integer, Integer> mapIndex = new HashMap<>();
        for(int i=0 ; i<list.size();i++){
            if(freqn_count.containsKey(list.get(i))){
                freqn_count.put(list.get(i),freqn_count.get(list.get(i))+1);
            }else{
                freqn_count.put(list.get(i),1);
                mapIndex.put(list.get(i),i); // map to capture first occurrence of each element
            }
        }
        //Comparartor compareTo functions
        Collections.sort(list, (n1,n2)->{
            int freqn1 = freqn_count.get(n1);
            int freqn2 = freqn_count.get(n2);
            if(freqn2 != freqn1){
                return freqn2-freqn1;
            }else{
                return mapIndex.get(n1) - mapIndex.get(n2); // Elements with Lesser Index gets Higher Priority
            }
        });
    }
}
