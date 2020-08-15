package DictionaryWord;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordBreak_Mine_140 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		String[] arrWords = sc.nextLine().split(",");
		List<String> words = new ArrayList<String>();
		for (int i = 0; i < arrWords.length; i++) {
			words.add(arrWords[i]);
		}

		System.out.print(isWordBreakable(str, words));
		sc.close();

	}

	private static boolean isWordBreakable(String str, List<String> words) {
		
		if (words.size() == 0 || str.isEmpty())
			return false;
		if(words.contains(str) || words.isEmpty()) return true;
		
		int i = 0;
		boolean isbreakable = false;
		String strCopy = str, appendString = "";
		if (words.size() == 0 || str.isEmpty())
			return false;
		if (words.contains(str) || words.isEmpty())
			return true;

		for (i = 1; i <= strCopy.length() && isbreakable == false; i++) {
			String segmented = strCopy.substring(0, i);
			if (words.contains(segmented)) {
				appendString += segmented;
				strCopy = strCopy.substring(i);
				i = 0;
				if (appendString.equals(str))
					isbreakable = true;
				else isbreakable = false;
			}
		}
		return isbreakable;
	}
}

/*
 * inputs :
 * 
 * applepenapple - apple,pen --- true
 * 
 * cars - car,ca,rs -- true
 * 
 * catsandog - cats,dog,sand,and,cat --- false
 * 
 * aaaaaaaa - aaaa,aaa,aa ---- true
 * 
 */
