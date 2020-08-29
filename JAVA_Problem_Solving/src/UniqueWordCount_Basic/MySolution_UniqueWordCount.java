package UniqueWordCount_Basic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MySolution_UniqueWordCount {
public static void main(String args[]) {
		
		Scanner sc_in = new Scanner(System.in);
		String[] inputStr = sc_in.nextLine().split(" ");
		
		Set<String> uniqueList = new HashSet<String>();
		System.out.print(finduniqueWord(inputStr, uniqueList));
		
		sc_in.close();
	}

	private static int finduniqueWord(String[] inputStr, Set<String> uniqueList) {
		for (int i = 0; i < inputStr.length; i++) {
			uniqueList.add(inputStr[i].toLowerCase());
		}
		return uniqueList.size();
	}
}
