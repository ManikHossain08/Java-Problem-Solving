package TextJustification;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextJustification_68 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String[] strInp = sc.nextLine().split(",");
		int maxWidth = sc.nextInt();
		List<String> result = findTextJustification(strInp, maxWidth);
		System.out.print(result);
		sc.close();
	}

	private static List<String> findTextJustification(String[] strInp, int maxWidth) {
		List<String> result = new ArrayList<String>();
		List<String> words = new ArrayList<String>();
		List<String> tempWords = new ArrayList<String>();
		int totallength = 0;
		boolean flag = false;

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < strInp.length; i++) {
			words.add(strInp[i]);
		}

		for (int i = 0; i < words.size(); i++) {

			sb.append(words.get(i) + " ");
			tempWords.add(words.get(i) + " ");
			
			// checking the length after appending each string with boundary condition (MaxLength)
			if (i < words.size() - 1)
				totallength = sb.length() + words.get(i + 1).length();
			else
				totallength = sb.length();

			if (totallength > maxWidth || i == words.size() - 1) {
				if (i != words.size() - 1)
					flag = false;
				else
					flag = true;
				tempWords.set(tempWords.size() - 1, tempWords.get(tempWords.size() - 1).strip());
				String senLength= sb.toString(); // strip() did not worked on StringBuilder so we convert into string then
				senLength = senLength.strip();
				organizeWord(result, tempWords, senLength.length(), maxWidth, flag);
				tempWords = new ArrayList<String>();
				sb = new StringBuilder();
			}
		}

		return result;
	}

	private static void organizeWord(List<String> result, List<String> tempWords, int senLength, int maxWidth,
			boolean flag) {
		int countSpace = maxWidth - senLength;
		int counter = 0;
		StringBuilder sb = new StringBuilder();
		// padding middle line with white space and a flag(false) indicate middle line
		for (int i = 0; i < countSpace && flag == false; i++) {
			tempWords.set(counter, tempWords.get(counter) + " ");
			counter++;
			if (counter >= tempWords.size() - 1)
				counter = 0;
		}
		// padding only last line with white space and a flag(true) indicate last line
		for (int i = 0; i < countSpace && flag == true; i++) {
			tempWords.set(tempWords.size() - 1, tempWords.get(tempWords.size() - 1) + " ");
		}

		for (int i = 0; i < tempWords.size(); i++) {
			sb.append(tempWords.get(i));
		}

		result.add(sb.toString());

	}
}
// Inputs
// Science,is,what,we,understand,well,enough,to,explain,to,a,computer.,Art,is,everything,else,we,do - 20
// This,is,an,example,of,text,justification. - 16
// What,must,be,acknowledgment,shall,be -16
// ask,not,what,your,country,can,do,for,you,ask,what,you,can,do,for,your,country - 16
