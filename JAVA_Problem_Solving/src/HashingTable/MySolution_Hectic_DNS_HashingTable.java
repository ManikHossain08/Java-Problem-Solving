package HashingTable;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MySolution_Hectic_DNS_HashingTable {
	public static Map<Integer, Integer> hashmap = new HashMap<Integer,Integer>(); 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		sc.nextLine();
		String[] inputs = sc.nextLine().split(" ");
		
		int[] hashtable = new int[inputs.length-1];
		for (int i = 0; i < inputs.length; i++) {
			int a = Integer.parseInt(inputs[i]);
			if(a != -1) {
				hashtable[i] = a;
				hashmap.put(i,0);
			}
		}
		
		hashingTable(hashtable, size);
		sc.close();
	}

	private static void hashingTable(int[] inputs, int size) {
		
		for (int i = 0; i < inputs.length; i++) {
			processByRules(inputs[i], size, i);
			System.out.println();
		}
		
	}

	private static void processByRules(int value, int size, int index) {
		
		int idx_remainder = value % size;
		
		if(hashmap.get(idx_remainder) == 0) {
			
			hashmap.put(idx_remainder, 1);
			System.out.print(idx_remainder);
			
		}else if( hashmap.get(idx_remainder) == 1){
			System.out.print(idx_remainder);
			processAgain(value, size, idx_remainder);
		}
	}

	private static void processAgain(int value, int size, int idx_remainder) {
		
		while(idx_remainder != -1) {
			int removedDigit = value % 10;
			int remainingDigits = value/10;
			if(removedDigit < hashmap.size()) 
				System.out.print(removedDigit);
			
			idx_remainder = remainingDigits % size;
			
			if(hashmap.get(idx_remainder) == 0) {
				hashmap.put(idx_remainder, 1);
				System.out.print(idx_remainder);
				
			}else if(removedDigit % 2 == 0 || removedDigit == 0){ // even
				int backwordDigit = removedDigit;
				while(hashmap.get(backwordDigit) == 1) {
					backwordDigit --;
					if(backwordDigit < 0) backwordDigit = hashmap.size() - 1;
				}
				System.out.print(backwordDigit);
				hashmap.put(backwordDigit, 1);
			}
			else if(removedDigit % 2 == 1){ // odd
				int forwardwordDigit = removedDigit;
				while(hashmap.get(forwardwordDigit) == 1) {
					forwardwordDigit ++;
					if(forwardwordDigit > hashmap.size() - 1) 
						forwardwordDigit = 0;
				}
				System.out.print(forwardwordDigit);
				hashmap.put(forwardwordDigit, 1);
			}
			idx_remainder = -1;
		}
	}
}







