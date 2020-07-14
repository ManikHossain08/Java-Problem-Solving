package HashingTable;

import java.util.ArrayList;
import java.util.Scanner;

public class HashingTable {
	
	private static final int EMPTY = -1;
    private static final int REMOVAL = 0;
    private static final int REMAIN = 1;

    private static int[] table;
    private static int tableSize;
    private static ArrayList<String> searchPath;

    public static void main(String[] args) {

        searchPath = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        tableSize = Integer.parseInt(scanner.nextLine());
        table = new int[tableSize];

        // initialize the table with -1, indicate that
        // the slot is empty
        for (int i = 0; i < tableSize; i++) table[i] = EMPTY;

        String[] inputs = scanner.nextLine().split(" ");
        scanner.close();

        for (String input : inputs) {
            int curInt = Integer.parseInt(input.trim());
            // if current integer is -1 means we are at
            // the end of the input data then do nothing
            if (curInt != EMPTY) {
                int[] rm = new int[2];
                rm[REMAIN] = curInt;
                int pos = curInt % tableSize;
                searchPath.add("\n" + String.valueOf(pos));

                while (pos != EMPTY && table[pos] != EMPTY) {
                    if (removable(rm[REMAIN])) {
                        // if the current integer can be removed
                        // the most right most digit
                        removeRightMost(rm);
                        pos = getPos(rm[REMOVAL], rm[REMAIN] % tableSize, pos);
                        searchPath.add(" " + String.valueOf(pos));
                    } else {
                        // if the current integer cannot be removed
                        // the right most digit, then search the table
                        // from the pos
                        if (rm[REMAIN] == curInt) pos = findEmpty(rm[REMAIN], pos);
                        else pos = findEmpty(rm[REMOVAL], pos);
                    }
                }
                // if the slot is empty, put the current
                // integer into the slot
                if (pos != EMPTY) {table[pos] = curInt;}
            }
        }

        for (String str : searchPath) {
            System.out.print(str);
        }
    }

    private static int getPos(int removedInt, int step, int pos) {
        if (removedInt % 2 != 0) {
            // if the removed integer is odd, move forward
            return (pos + step) % tableSize;
        } else {
            // otherwise, move backward
            if (step <= pos) {
                return pos - step;
            } else {
                return tableSize - (step - pos);
            }
        }
    }

    private static int findEmpty(int removedInt, int pos) {
        int counter = table.length;
        if (removedInt % 2 != 0) {
            // if the removed integer is odd, move forward
            for (; counter > 0; pos++, counter--) {
                pos = pos % tableSize;
                searchPath.add(" " + pos);
                if (table[pos] == EMPTY) return pos;
            }
        } else {
            // otherwise, move backward
            for (; counter > 0; pos--, counter--) {
                pos = Math.abs(pos % tableSize);
                searchPath.add(" " + pos);
                if (table[pos] == EMPTY) return pos;
            }
        }

        return EMPTY;
    }

    private static boolean removable(int remainInt) {
        return remainInt / 10.0 > 1.0;
    }

    private static void removeRightMost(int[] rm) {
        rm[REMOVAL] = rm[REMAIN] % 10;
        rm[REMAIN] = rm[REMAIN] / 10;
    }

}
