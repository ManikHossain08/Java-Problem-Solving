package TranscriptNamePrinting_Basic;

import java.util.Scanner;

public class PersonNamePriniting {
	private static String vowels = "aeiouAEIOU";

	public static void main(String args[]) {
		Scanner sc_in = new Scanner(System.in);
		String[] fullName = sc_in.nextLine().split(" ");
		if (fullName.length > 0)
			System.out.print(transcriptNamePrinting(fullName));

		sc_in.close();
	}

	private static String transcriptNamePrinting(String[] fullName) {
		String name = null;
		if (fullName.length == 1) {
			name = fullName[0];
			return name;
		} else if (fullName.length == 2) {
			if (vowels.indexOf(fullName[1].charAt(fullName[1].length() - 1)) != -1) {
				return fullName[1] + " " + fullName[0];
			} else
				return fullName[0] + " " + fullName[1];
		} else {
			name = fullName[fullName.length - 1];
			for (int i = 0; i < fullName.length - 1; i++) {
				name += " " + fullName[i];
			}
		}

		return name;
	}

}
