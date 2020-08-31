package predictPattern_N_Gram_Problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class MySolution_N_Gram {

	public static Map<String, Integer> gramRecord = new HashMap<String, Integer>();
	public static List<String> maxList = new ArrayList<String>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int lineno = sc.nextInt();
		sc.nextLine();
		String[] inputs = new String[lineno];
		for (int i = 0; i < lineno; i++) {
			inputs[i] = sc.nextLine();
		}

		int gramType = sc.nextInt();

		System.out.print(findNGram(inputs, gramType));
		sc.close();

	}

	private static String findNGram(String[] inputs, int gramType) {
		String result = "";
		gramRecord = new HashMap<String, Integer>();
		maxList = new ArrayList<String>();
		
		switch (gramType) {
		case 1:
			result = findUniGram(inputs, gramType);
			break;
		case 2:

			result = findBiGram(inputs, gramType);
			break;

		default:
			result = findTriGram(inputs, gramType);
			break;
		}

		return result;
	}


	private static String findUniGram(String[] inputs, int gramType) {

		return "Unigram " + processingInputParas(inputs, gramType);
	}

	private static String findBiGram(String[] inputs, int gramType) {

		return "Bigram " + processingInputParas(inputs, gramType);
	}

	private static String findTriGram(String[] inputs, int gramType) {

		return "Trigram " + processingInputParas(inputs, gramType);
	}
	
	private static String processingInputParas(String[] inputs, int gramType) {
		for (int i = 0; i < inputs.length; i++) {
			String paras = inputs[i];
			for (int j = 0; j <= paras.length() - gramType; j++) {
				String subString = paras.substring(j, j + gramType).strip();
				if (subString.length() == gramType) {
					if (subString.contains(".") || subString.contains(",")) continue;
					else gramRecord.put(subString, gramRecord.getOrDefault(subString, 0) + 1);
				}
			}
		}

		int max = Collections.max(gramRecord.values()).intValue();

		for (Entry<String, Integer> nGramMap : gramRecord.entrySet()) {
			int value = nGramMap.getValue();
			if (max == value) {
				maxList.add(nGramMap.getKey());
			}
		}

		Collections.sort(maxList, (a, b) -> {
			if (a.length() != b.length())
				return a.length() - b.length();
			return a.compareTo(b);
		});

		return maxList.get(0);
	}

}
