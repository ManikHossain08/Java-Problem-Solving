package DictionaryWord;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class WordLadder_127 {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String beginWord = sc.nextLine();
		String endWord = sc.nextLine();

		String[] arrWords = sc.nextLine().split(",");
		List<String> words = new ArrayList<String>();
		for (int i = 0; i < arrWords.length; i++) {
			words.add(arrWords[i]);
		}

		System.out.println(countWordLadder(beginWord, endWord, words));
		sc.close();

	}

	private static int countWordLadder(String beginWord, String endWord, List<String> words) {

		int length = 0;
		if (!words.contains(endWord))
			return length;
		if (words.contains(beginWord) && words.contains(endWord) && words.size() == 2) {
			return length;
		}
		if (beginWord.equals(endWord)) {
            return 1;
        }

		List<String> visitedWords = new ArrayList<String>();
		Queue<String> queue = new LinkedList<String>();
		visitedWords.add(beginWord);
		queue.offer(beginWord);

		while (!queue.isEmpty()) {
			length++;
			int queueSize = queue.size();
			for (int i = 0; i < queueSize; i++) {
				String start = queue.poll();

				if (start.equals(endWord)) {
					//if(length == 1) length --;
					return length;
				}

				for (int index = 0; index < start.length(); index++) {
					StringBuilder sb = new StringBuilder(start);
					for (char ch = 'a'; ch <= 'z'; ch++) {
						sb.setCharAt(index, ch);
						if (words.contains(sb.toString()) && !visitedWords.contains(sb.toString())) {
							visitedWords.add(sb.toString());
							queue.offer(sb.toString());
						}
					}
				} // set/replacing char end loop
			} // end of queue loop
		} // end of while loop

		return length;
	}

}
/*
 * Input-1: ymain oecij
 * ymann,yycrj,oecij,ymcnj,yzcrj,yycij,xecij,yecij,ymanj,yzcnj,ymain -- o/p = 10
 * 
 * input -2
 * 
 * hit cog --- hot,dot,dog,lot,log,cog
 * 
 * input -3:
 * hot dog --- hot,dog  0
 * 
 * input-4
 * 
 * talk, tail --- talk,tons,fall,tail,gale,hall,negs -o/p = 0
 * 
 */
