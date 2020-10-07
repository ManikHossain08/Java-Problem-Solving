package StringOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LC1324_PrintWordsVertically {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inputs = sc.nextLine();

		System.out.print(printVertically(inputs));
		sc.close();
	}

	private static List<String> printVertically(String inputs) {
		List<String> result = new ArrayList<String>();
		String[] strList = inputs.split(" ");
		int maxLenth = 0;
		for (int i = 0; i < strList.length; i++) {
			strList[i] = strList[i].strip();
			maxLenth = Math.max(maxLenth, strList[i].length());
		}

		for (int i = 0; i < maxLenth; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < strList.length; j++) {
				char ch = ' ';
				if (i <= strList[j].length() - 1) {
					ch = strList[j].charAt(i);
				}
				sb.append(ch);
			}
			result.add(sb.toString().stripTrailing());
		}

		return result;
	}
}
