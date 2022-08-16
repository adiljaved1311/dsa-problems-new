package neetcode.arraysAndHashing;

public class ArrayProduct {
    public static void main(String[] args) {
        int a[] = {1,2,3,4};
        a = productExceptSelf(a);
        for(int x:a)
            System.out.print(x+" ");
    }
    public static int[] productExceptSelf(int[] a) {
        int[] output = new int[a.length];     //  2,3,4,1
        int temp = a[0];
        output[0] = 1;
        for(int i=1; i<a.length; i++)   // left products
        {
            output[i] = temp;
            temp = temp*a[i];
        }
        temp = a[a.length-1];
        for(int i=a.length-2; i>=0; i--)  // right products
        {
            output[i] = temp*output[i];
            temp = temp*a[i];
        }
        return output;
    }
}
