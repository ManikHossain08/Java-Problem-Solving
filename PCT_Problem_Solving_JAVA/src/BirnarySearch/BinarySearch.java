package BirnarySearch;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class BinarySearch {
	public static void main(String args[]) {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String[] columnsStr = input.nextLine().split(" ");

		int searchValue = input.nextInt();

		ArrayList<Integer> datasInArray = new ArrayList<Integer>();
		int[] sortedNumber = new int[columnsStr.length];

		for (int i = 0; i < columnsStr.length; i++) {
			datasInArray.add(Integer.parseInt(columnsStr[i]));
		}
		Collections.sort(datasInArray);
		// System.out.println(datasInArray);

		for (int index = 0; index < datasInArray.size(); index++) {
			sortedNumber[index] = datasInArray.get(index);
			// System.out.println(sortedNumber[index]);
		}

		// System.out.println(searchValue);

		int num = sortedNumber.length, item = searchValue, first, last, middle, iterator = 1;
		first = 0;
		last = num - 1;
		middle = (first + last) / 2;

		while (first <= last) {
			if (sortedNumber[middle] < item) {
				if (iterator == 1)
					System.out.print("1");
				else
					System.out.print(" 1");
				first = middle + 1;
			} else if (sortedNumber[middle] == item) {
				System.out.print(" found");
				break;
			} else {
				if (iterator == 1)
					System.out.print("-1");
				else
					System.out.print(" -1");
				last = middle - 1;
			}
			middle = (first + last) / 2;
			iterator++;
		}
		if (first > last)
			System.out.print(" notfound");

	}
}
