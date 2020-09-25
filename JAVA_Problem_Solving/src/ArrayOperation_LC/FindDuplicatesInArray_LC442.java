package ArrayOperation_LC;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindDuplicatesInArray_LC442 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] a = new int[size];
		for (int i = 0; i < size; i++) {
			a[i] = sc.nextInt();
		}

		System.out.print(duplicateNumber(a));
		sc.close();
	}

	private static List<Integer> duplicateNumber(int[] a) {

		List<Integer> result = new ArrayList<Integer>();
		
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] == a[j]) {
					result.add(a[i]);
					break;
				}
			}
			
		}

		return result;
	}
}
