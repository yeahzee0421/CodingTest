import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < tc; t++) {
            String str = br.readLine();
            Stack<Character> leftArrowStack = new Stack<>();
            Stack<Character> rightArrowStack = new Stack<>();

            for (char ch : str.toCharArray()) {
            switch (ch) {
                case '<':
                    if (!leftArrowStack.isEmpty()) {
                    	rightArrowStack.push(leftArrowStack.pop());
                    }
                    break;
                case '>':
                    if (!rightArrowStack.isEmpty()) {
                    	leftArrowStack.push(rightArrowStack.pop());
                    }
                    break;
                case '-':
                    if (!leftArrowStack.isEmpty()) {
                        leftArrowStack.pop();
                    }
                    break;
                default:
                    leftArrowStack.push(ch);
                    break;
                }
            }

            while (!leftArrowStack.isEmpty()) 
            	rightArrowStack.push(leftArrowStack.pop());

            while (!rightArrowStack.isEmpty()) 
                sb.append(rightArrowStack.pop());
            
            
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}
