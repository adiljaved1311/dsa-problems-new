package array;

import java.util.*;

// Find all the duplicates present in an array

public class Duplicate {
	public static void main(String[] args) {
		int a[] = { 2, 5, 8, 7, 5, 6, 5,2, 1, 8 };
		List<Integer> list = duplicates(a);
		for (int x : list)
			System.out.print(x + " ");
	}

	
	public static List<Integer> duplicates(int a[]) {
		HashSet<Integer> set = new HashSet<>();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < a.length; i++) {
			if (!set.add(a[i]))
				list.add(a[i]);
		}
		return list;
	}
}
