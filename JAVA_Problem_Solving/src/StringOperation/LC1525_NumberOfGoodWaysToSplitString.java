package StringOperation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;




public class LC1525_NumberOfGoodWaysToSplitString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();

		System.out.print(numSplits(s));
		System.out.print(numSplits_2(s));
		sc.close();
	}

	
	public static int numSplits(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); ++i){
        	char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int count = 0;
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); ++i){
        	char ch = s.charAt(i);
            set.add(ch);
            map.put(ch, map.get(ch) - 1);
            if(map.get(ch) == 0) map.remove(ch);
            if(set.size() == map.size()) count++;
        }
        return count;
    }
	
	
	private static int numSplits_2(String str) {
		int left[] = new int[26], right[] = new int[26]; 
		int leftDistinct = 0, rightDistinct = 0; 
		int result = 0;
	    var s = str.toCharArray();
	    
	    for (char ch : s) {
	    	right[ch - 'a']++;
	    	if(right[ch - 'a'] == 1) rightDistinct++;
	    }
	    for (char ch : s) {
	    	left[ch - 'a']++;
	    	if(left[ch - 'a'] == 1) leftDistinct++;
	    	
	    	right[ch - 'a']--;
	    	if(right[ch - 'a'] == 0) rightDistinct--;
	    	
	    	if(leftDistinct == rightDistinct) result++;
	    	
	    	// THIS 3 LINES OF CODE DO SAME THINGS IN THE ABOVE
//			d_l += ++l[s[i] - 'a'] == 1 ? 1 : 0;
//			d_r -= --r[s[i] - 'a'] == 0 ? 1 : 0;
//			res += d_l == d_r ? 1 : 0;
	    	
	    }
	    return result;
	}
}
	
	/*
	// THIS CODE IMPLEMENTED BY ME BUT DID NOT ACCEPTED
	// DID NOT ACCEPTED: 53 / 61 test cases passed.
	// Status: Time Limit Exceeded
	 * 
	private static int numSplits(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if(isGood(s, i, i + 1))
				count++;
				
		}
		return count;
	}

	private static boolean isGood(String str, int left, int right) {
		Set<Character> s1 = new HashSet<Character>();
		Set<Character> s2 = new HashSet<Character>();

		String str1 = str.substring(0, right);
		String str2 = str.substring(right, str.length());

		for (int i = 0; i < str1.length(); i++) {
			s1.add(str1.charAt(i));
		}

		for (int i = 0; i < str2.length(); i++) {
			s2.add(str2.charAt(i));
		}

		return s1.size() == s2.size();
	}
	*/
	

