package BasicProblemSolving;

import java.util.Scanner;

public class ContainerWithMostWater {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String[] inputArr = sc.nextLine().split(",");
		int[] arrInp = new int[inputArr.length];
		for (int i = 0; i < inputArr.length; i++) {
			arrInp[i] = Integer.parseInt(inputArr[i]);
		}

		System.out.print(findContainerArea(arrInp));
		sc.close();
	}

	private static int findContainerArea(int[] arrInp) {
		int totalMax = 0;
		// List<Integer> areaList = new ArrayList<Integer>();
		for (int i = 0; i < arrInp.length; i++) {
			for (int j = arrInp.length - 1; j > i; j--) {
				int areaHeight = (Math.min(arrInp[i], arrInp[j]) * (j - i));
				if (totalMax < areaHeight) {
					totalMax = areaHeight;
				}
			}
		}
		return totalMax;
	}
}
