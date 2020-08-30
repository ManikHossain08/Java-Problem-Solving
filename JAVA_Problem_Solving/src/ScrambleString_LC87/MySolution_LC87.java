package ScrambleString_LC87;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
	Intiution:
	
	Step 1:
	lets take a simpler example: "abc" & "bca".
	
	Step 2:
	abc can be split in the following => {a,bc} {ab, c}
	on swapping the values you can also generate reverse of substrings => {bc,a} and {c, ab}
	
	Step 3:
	All possible combinations of abc from step-2 are: {a,bc} {ab, c} & {bc,a} and {c, ab}
	
	Step 4:
	Similarly "bac" becomes: {b, ca} {bc, a} & {ca, b} {a, bc}
	
	Step 5:
	Take the Step3 and Step4 results and recursively analyze if any of the combination results are same, the return TRUE 
	otherwise FALSE.
	

 */

public class MySolution_LC87 {
	public static Map<String, Boolean> memo = new HashMap<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();

		System.out.print(isScramble(s1, s2));

		sc.close();
	}

	private static boolean isScramble(String s1, String s2) {

		int[] frqMeter = new int[26];
		int strLen = s1.length();

		if (s1.equals(s2))
			return true;
		if (s1.length() != s2.length())
			return false;

		for (int i = 0; i < strLen; i++) {
			frqMeter[s1.charAt(i) - 'a']++;
			frqMeter[s2.charAt(i) - 'a']--;
		}

		for (int i = 0; i < frqMeter.length; i++) {
			if (frqMeter[i] != 0)
				return false;
		}

		for (int i = 1; i < s2.length(); i++) {
			//word: gre
			String s1_left_Changed = s1.substring(0, strLen - i); // (gr, e)
			String s1_right_Changed = s1.substring(strLen - i, strLen);

			String s1_left_NoExchng = s1.substring(0, i); // (g, re)
			String s1_right_NoExchng = s1.substring(i, strLen);

			String s2_left = s2.substring(0, i); // (e, gr)
			String s2_right = s2.substring(i, strLen);
			
			// s1 = {a, bc} {ab, c} & {bc,a}  {c, ab}
			// s2 = {b, ca} {bc, a} & {ca, b} {a, bc}
			
			boolean noChanged = isScramble(s1_left_NoExchng, s2_left) && isScramble(s1_right_NoExchng, s2_right);
			if(noChanged) return true;
			boolean changed = isScramble(s1_left_Changed, s2_right) && isScramble(s1_right_Changed, s2_left);
			if(changed) return true;
			
		}
		
		return false;
	}

}
