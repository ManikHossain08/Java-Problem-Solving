package BestTimeToBuyAndSellStockIII_123;

import java.util.Scanner;

public class BestTimeToBuyAndSellStockIII_123 {
	// this code is for two transactions
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int numInp = sc.nextInt();
		int[] arrInp = new int[numInp];
		for (int i = 0; i < numInp; i++) {
			arrInp[i] = sc.nextInt();
		}
		System.out.print(bestTimeToBuyAndSell(arrInp));
		sc.close();
	}

	private static int bestTimeToBuyAndSell(int[] prices) {
		
		int oneBuy = Integer.MAX_VALUE;
        int twoBuy = Integer.MAX_VALUE;
        int oneBuyOneSell = 0;
        int twoBuyTwoSell = 0;
        
        for (int i = 0; i < prices.length; i++) {
        	// this code is for two transactions
            oneBuy = Math.min(oneBuy, prices[i]);
            oneBuyOneSell = Math.max(oneBuyOneSell, prices[i] - oneBuy);
            twoBuy = Math.min(twoBuy, prices[i] - oneBuyOneSell);
            twoBuyTwoSell = Math.max(twoBuyTwoSell, prices[i] - twoBuy);
        }
        
        return twoBuyTwoSell;
	}

}
