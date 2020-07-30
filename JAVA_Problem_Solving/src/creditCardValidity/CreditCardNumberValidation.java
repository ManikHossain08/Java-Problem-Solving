package creditCardValidity;

//import java.util.Arrays;
import java.util.Scanner;

public class CreditCardNumberValidation {
	public static void main(String args[]) {

		int totalSum = 0;

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String inputStr = input.nextLine();

		totalSum = totalSum + getSummetionOfDirectDigit(inputStr);
		totalSum = totalSum + getSummetionOfDoubledDigit(inputStr);

		System.out.println(totalSum);
		if (totalSum % 10 == 0) {
			System.out.println("Valid");
		} else {
			System.out.println("Invalid");
		}

	}

	private static int getSummetionOfDoubledDigit(String columnsStr) {
		int Sum = 0;
		for (int i = columnsStr.length() - 2; i >= 0; i = i - 2) {
			// Integer.parseInt(conv_num.charAt(i) + "")
			int charVal = Character.getNumericValue(columnsStr.charAt(i));
			charVal = charVal * 2;
			Sum = Sum + getSummetionOfDigit(charVal + "");

		}

		return Sum;

	}

	private static int getSummetionOfDirectDigit(String columnsStr) {
		int sum = 0;
		for (int i = columnsStr.length() - 1; i >= 0; i = i - 2) {
			sum = sum + Character.getNumericValue(columnsStr.charAt(i));
		}
		return sum;
	}

	private static int getSummetionOfDigit(String columnsStr) {
		int singleSum = 0;
		for (int i = 0; i < columnsStr.length(); i++) {
			singleSum = singleSum + Character.getNumericValue(columnsStr.charAt(i));
		}
		return singleSum;
	}
}
