package SubstringWithConcatenationofAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SubstringByConcatenatingAllWords_30 {
	// this code is not working I dont know why but after copy paste from leetcode
	// it is not working. 
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		String inpString = sc.nextLine();
		String[] words = sc.nextLine().split(",");
		System.out.print(getSolution(inpString, words));
		sc.close();
	}

	private static List<Integer> getSolution(String s, String[] words) {

		List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0)
            return res;
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        int n = s.length(), num = words.length, base = words[0].length();
        for (int i = 0; i < n - num * base + 1; i++) {
            Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            for (; j < num; j++) {
                String tmp = s.substring(i + j * base, i + (j + 1) * base);
                if (!count.containsKey(tmp)){
                    break;
                }
                seen.put(tmp, seen.getOrDefault(tmp, 0) + 1);
                if (seen.get(tmp) > count.get(tmp)) {
                    break;
                }
            }
            if (j == num) {
                res.add(i);
            }
        }
        return res;
	}
}
