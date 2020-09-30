package A_GameOfLife;

import java.util.Scanner;

public class LC_289_Game_Of_Life {
	
	private static int[][] DIRECTIONS = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, -1 }, { 1, 1 },
			{ -1, 1 }, { -1, -1 } };
			
	/*
	 * RULES:
	 * 1. Any live cell with fewer than two live neighbors dies, as if caused by under-population.
	   2. Any live cell with two or three live neighbors lives on to the next generation.
	   3. Any live cell with more than three live neighbors dies, as if by over-population..
	   4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
	 */
	/*
	 * THIS CODE IS DEVELOPED FOR ONLY ONE GENERATION BUT THE OTHER ONE IS FOR THE N NUMBER OF THE 
	 * GENERATION.
	 * 
	 * HOWEVER, BOTH PROBLEMS ARE SAME INTERM OF THE RULES AND CODING STRUCTURE.	
	 */
	
			
	public static void main(String args[]) {
		// input processing

		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int[][] board = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		gameOfLife(board);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

		sc.close();
	}

	public static void gameOfLife(int[][] board) {
		// STATE	//NEW STATE
		// 0-> 		0
		// 1-> 		1
		// 2-> 		0->1
		// 3-> 		1->0

		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[i].length; j++)
				board[i][j] = getNextState(i, j, board);

		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[i].length; j++) {
				int state = board[i][j];
				if (state == 0 || state == 1)
					continue;
				else if (state == 2)
					board[i][j] = 1;
				else if (state == 3)
					board[i][j] = 0;
			}
	}

	private static int getNextState(int i, int j, int[][] board) {
		int numLiveNeighbors = 0;
		int currState = board[i][j];
		for (int[] dir : DIRECTIONS) {
			int newI = i + dir[0], newJ = j + dir[1];
			boolean outOfBounds = newI < 0 || newI >= board.length || newJ < 0 || newJ >= board[newI].length;
			if (outOfBounds)
				continue;
			if (board[newI][newJ] == 1 || board[newI][newJ] == 3)
				numLiveNeighbors++;
		}

		if ((currState == 1 && numLiveNeighbors < 2) || (currState == 1 && numLiveNeighbors > 3)) // RULES # 1 & 3
			return 3;
		else if (currState == 1 && (numLiveNeighbors == 2 || numLiveNeighbors == 3)) // RULES # 2
			return 1;
		else if (currState == 0 && numLiveNeighbors == 3) // RULES # 4
			return 2;
		return currState;
	}
}
