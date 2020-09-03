package Find_Min_String_Windows;

import java.util.HashSet;
import java.util.Scanner;

public class OtherProblemSameConcept_LongestSubstring_LC3 {

	// IMPORTANT NOTE: https://stackoverflow.com/questions/15505508/what-is-the-difference-between-string-substring-and-string-subsequence
	// SUBSTRING AND SUBSEQUENCE IS NOT SAME
	/*
	In simple terms of understanding:

	SUBSTRING : A substring is a contiguous sequence of characters within a string, where oder matters.
	
	Substring
	string
	ring
	SUBSEQUENCE: From a string, any of the character but in sequence.
	
	Substring
	u s i
	s b t i n g
	r g
	
	 */
	
	// THIS CODE CONCEPT IS LITTLE BIT SIMILAR WITH MIN WINDOW SUBTRING 
	// I USE THIS CODE CONCEPT FOR SOLVING THE MIN WINDOWS STRING
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
