package array;
// Given a sorted array of integers having negative and positive value, you have to return a new array which
// is squares of each element of array and this array must be sorted.
public class Square 
{
	public static void main(String[] args) 
	{
		int a[] = {-6,-4,-1,2,3,5,6,8,9};
		int b[] = square(a);
		for(int x:b)
			System.out.print(x+" ");
		System.out.println();
		int c[] = square(a);
		for(int x:c)
			System.out.print(x+" ");
	}
	public static int[] square(int a[])
	{
		int arr[] = new int[a.length];
		int left = 0;
		int right = a.length-1;
		for(int i=a.length-1;i>=0;i--)
		{
			if(Math.abs(a[left])>a[right])
			{
				arr[i] = a[left]*a[left];
				left++;
			}else
			{
				arr[i] = a[right]*a[right];
				right--;
			}
		}
		return arr;
	}
	public static int[] square2(int a[]){
		int arr[] = new int[a.length];
		int left = 0;
		int right = a.length - 1;
		int index = a.length - 1;
		while(left <= right){
			if(Math.abs(a[left]) > Math.abs(a[right])){
				arr[index] = a[left];
				left++;
				index--;
			}else{
				arr[index] = a[right];
				right--;
				index--;
			}
		}
		return arr;
	}
}
