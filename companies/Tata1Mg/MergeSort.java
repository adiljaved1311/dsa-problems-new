package companies.mongodb;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[]arr = {9,4,6,7,3,1,5};
        mergeSort(arr,0,6);
        System.out.println(Arrays.toString(arr));
    }
    public static void mergeSort(int[] arr, int left, int right){
        if(left < right){
            int mid = (left + right)/2;
            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,right);
            merge(arr,left,mid,right);
        }
    }
    public static void merge(int[] a, int lower, int mid, int upper){
        // Start Merging
        int len = (upper-lower)+1;
        int b[] = new int[len];
        int left = lower;
        int right = mid+1;
        int i = 0;

        while(left <= mid && right <= upper)
        {
            if(a[left] <= a[right])
                b[i++] = a[left++];
            else
                b[i++] = a[right++];
        }

        for(; left <= mid; left++,i++)
        {
            b[i] = a[left];
        }

        for(; right <= upper; right++,i++)
        {
            b[i] = a[right];
        }

        for(int k = 0, j=lower; j <= upper; k++,j++)
        {
            a[j] = b[k];
        }
    }
}
