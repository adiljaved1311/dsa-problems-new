package companies.paytm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDuplicates {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4 ,3};
        Set result = findDuplicates(arr);
        System.out.println(result.toString());
    }
    private static Set findDuplicates(int arr[]){
        Set duplicates = new HashSet();
        Set set = new HashSet();
        for(int i=0; i< arr.length; i++){
            if(!set.add(arr[i])){
                duplicates.add(arr[i]);
            }
        }
        return duplicates;
    }
}
