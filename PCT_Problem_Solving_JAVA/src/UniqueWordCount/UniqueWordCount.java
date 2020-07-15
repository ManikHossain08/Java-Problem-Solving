package UniqueWordCount;

import java.util.HashMap;
import java.util.Scanner;

public class UniqueWordCount {
	public static void main(String args[]) {
		
		Scanner sc_in = new Scanner(System.in);
		String[] inputStr = sc_in.nextLine().split(" ");
		
		HashMap<String, String> uniqueList = new HashMap<String, String>();
		System.out.print(finduniqueWord(inputStr, uniqueList));
		
		sc_in.close();
	}

	private static int finduniqueWord(String[] inputStr, HashMap<String, String> uniqueList) {
		int uniqeWord = 0;
		
		for (int i = 0; i < inputStr.length; i++) {
			String newWord = inputStr[i].toLowerCase();
			if(uniqueList.get(newWord) == null) {
				uniqueList.put(newWord.toLowerCase(), newWord);
				uniqeWord++;
			}
		}
		return uniqeWord;
	}
}
