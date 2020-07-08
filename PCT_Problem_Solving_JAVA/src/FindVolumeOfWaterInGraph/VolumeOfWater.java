package FindVolumeOfWaterInGraph;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class VolumeOfWater {
	public static void main(String args[]) {
		Scanner sc_in = new Scanner(System.in);
		String[] input = sc_in.nextLine().split(",");
		int totalVol = 0;
		int[] barLength = new int[input.length];
		
		for (int i = 0; i < input.length; i++) {
			barLength[i] = Integer.parseInt(input[i]);
		}
		System.out.print(findVolumeOfwater(barLength, totalVol));

		sc_in.close();
	}

	private static int findVolumeOfwater(int[] barLength, int totalVol) {
		int currentPosHeight = 0;
		
		for (int i = 1; i < barLength.length; i++) {
			Integer[] findMin = {0,0};
			int[] leftside = Arrays.copyOfRange(barLength, 0, i);
			int[] rightside = Arrays.copyOfRange(barLength, i + 1, barLength.length);

			if (leftside.length != 0)
				findMin[0] = Arrays.stream(leftside).max().getAsInt();
			
			if (rightside.length != 0)
				findMin[1] = Arrays.stream(rightside).max().getAsInt();
			

			currentPosHeight = (Collections.min(Arrays.asList(findMin)) - barLength[i]);
			if (currentPosHeight < 0)
				currentPosHeight = 0;
			totalVol += currentPosHeight;

		}

		return totalVol;
	}

}
