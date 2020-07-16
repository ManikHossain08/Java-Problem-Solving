package BiPrimeIdentify;

import java.util.ArrayList;
import java.util.Scanner;

public class FindBiPrimeNumber {
	public static void main(String args[]) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(sc.nextLine());
			int b = Integer.parseInt(sc.nextLine());
			list.add(findBiprime(a, b));
		}
		sc.close();
		String output = "";
		for (Integer a : list) {
			output += Integer.toString(a) + " ";
		}
		System.out.println(output.trim());
	}

	private static Integer findBiprime(int a, int b) {
		int bp = 0;
		for (int i = a; i <= b; i++) {
			if (checkSemiprime(i))
				bp++;
		}
		return bp;
	}

	private static boolean checkSemiprime(int num) {
		int cnt = 0;

		for (int i = 2; cnt < 2 && i * i <= num; i++) {

			while (num % i == 0) {
				num /= i;
				cnt++;
			}
		}
		if (num > 1)
			cnt++;
		return cnt == 2 ? true : false;
	}

}
