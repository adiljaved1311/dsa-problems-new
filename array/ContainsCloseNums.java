package array;

import java.util.*;

public class ContainsCloseNums {
// determine whether there are two different indices i and j in the array where a[i] = a[j]
// and the absolute difference between i and j is less than or equal two k

	public static void main(String[] args) {
		int a[] = { 0, 1, 11, 2,1, 3,1, 5, 2, 5 };
		int k = 2;
		System.out.println(containsCloseNums1(a, k));
		System.out.println(containsCloseNums2(a, k));
	}

	public static boolean containsCloseNums1(int a[], int k) // T -> O(n^2)
	{
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] == a[j]) {
					if (Math.abs((i - j)) <= k)
						return true;
				}
			}
		}
		return false;
	}

	// Time -> O(n) Space -> O(n)
	public static boolean containsCloseNums2(int a[], int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int p = -1;
		for (int i = 0; i < a.length; i++) {
			if (map.containsKey(a[i])) {
				if (Math.abs(map.get(a[i]) - i) <= k)
					//p = 1;
					return true;
			}
			map.put(a[i], i);
		}
//		if (p == 1)
//			return true;
//		else
//			return false;
		return false;
	}
}
