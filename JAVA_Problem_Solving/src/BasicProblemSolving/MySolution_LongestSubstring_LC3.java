package BasicProblemSolving;

import java.util.HashSet;
import java.util.Scanner;

public class MySolution_LongestSubstring_LC3 {

	public static HashSet<Character> hash_set = new HashSet<Character>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String words = sc.nextLine();
		System.out.print(getLognestSubstring(words));
		//System.out.print(hash_set);
		sc.close();
	}

	// this is sliding windows
	private static int getLognestSubstring(String s) {
		int a_pointer = 0;
		int b_pointer = 0;
		int max = 0;

		while (b_pointer < s.length()) {
			char c = s.charAt(b_pointer);
			if (!hash_set.contains(c)) {
				hash_set.add(c);
				b_pointer++;
				max = Math.max(hash_set.size(), max);
			} else {
				hash_set.remove(s.charAt(a_pointer));
				a_pointer++;
			}
		}

		return max;
	}

}
