package BasicProblemSolving;

import java.util.Scanner;
import java.util.Stack;

public class SimplifyPath_71 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String strInp = sc.nextLine();
		
		System.out.print(findSimplifyPath(strInp));
		sc.close();
	}

	private static String findSimplifyPath(String path) {
		String[] parts = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String s : parts) {
            if (s.isEmpty() || s.equals(".")) continue;
            else if (s.equals("..")) {
              if (!stack.isEmpty()) stack.pop();  
            } 
            else stack.push(s);
        }
        
        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append("/");
            sb.append(s);
        }
        
        if (sb.length() == 0) return "/";
        return sb.toString();
	}
}
