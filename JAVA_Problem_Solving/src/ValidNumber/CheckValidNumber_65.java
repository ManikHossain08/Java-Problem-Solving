package ValidNumber;

import java.util.Scanner;

public class CheckValidNumber_65 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String inpput = sc.nextLine();
		System.out.print(findValidNumber(inpput));
		sc.close();
	}

	private static boolean findValidNumber(String input) {
//		try {
//			Double.parseDouble(input.strip());
//			return true;
//		} catch (Exception e){
//			return false;
//		}

		// Alternative solution
		final String PATTERN = "[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?";
		return input.trim().matches(PATTERN);
	}
}
