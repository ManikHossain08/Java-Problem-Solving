package StringOperation;

import java.util.Scanner;

public class LC43_MultiplyStrings {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		System.out.print(multiply(str1, str2));
		sc.close();
	}

	private static String multiply(String num1, String num2) {

		char[] n1 = num1.toCharArray();
		char[] n2 = num2.toCharArray();
		int sum, p, q, t;
		int[] result = new int[n1.length + n2.length];
		for (int i = n1.length - 1; i >= 0; --i) {
			for (int j = n2.length - 1; j >= 0; --j) {
				p = i + j;
				q = p + 1;
				sum = (n1[i] - '0') * (n2[j] - '0') + result[q];
				t = sum * 103 >> 10; // fast version for sum/10
				result[p] += t;
				result[q] = sum - t * 10;
			}
		}
		p = q = 0;
		while (result[p] == 0)
			if (++p == result.length)
				return "0";
		char[] buff = new char[result.length - p];
		while (p < result.length)
			buff[q++] = (char) (result[p++] + '0');
		return new String(buff);
	}
}
