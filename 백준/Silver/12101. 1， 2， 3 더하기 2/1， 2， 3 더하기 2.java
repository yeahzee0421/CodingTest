import java.io.*;
import java.util.*;

public class Main{
    static int n, k;
    static int count = 0;
    static ArrayList<Integer> li;
    public static boolean backtracking(int num) {
    	if(num == n) {
    		count++;
    		if(count == k) 
    			return true;
    		return false;
    	}
    	
    	for(int i = 1; i <= 3; i++) {
    		if(num+i > n) 
    			continue;
    		
    		li.add(i);
    		if(backtracking(num+i)) {
    			return true;
    		}
    		li.remove(li.size() - 1);
    		//마지막 요소를 제거함으로써 복원작업.
    	}
    	return false;
    }
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        li = new ArrayList<Integer>();
        
        if(backtracking(0)) {
        	for(int i = 0; i < li.size(); i++)
        		if(i!=li.size()-1)
        			System.out.print(li.get(i)+"+");
        		else
        			System.out.print(li.get(i));
        }
        else System.out.println(-1);
    }

}
