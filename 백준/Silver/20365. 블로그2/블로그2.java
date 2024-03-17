import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	
    	StringBuilder sb = new StringBuilder();
    	String str = br.readLine();
    
    	char tmp = str.charAt(0);
    	sb.append(tmp);
    	for(int i = 1; i < n; i++) {
    		if(tmp != str.charAt(i)) {
    			sb.append(str.charAt(i));
    			tmp = str.charAt(i);
    		}
    	}
    	int count = 1;
    	char first = sb.charAt(0);
    	for(int i = 1; i < sb.length(); i++) {
    		if(first != sb.charAt(i)) count++;
    	}
    	System.out.println(count);
    }
}