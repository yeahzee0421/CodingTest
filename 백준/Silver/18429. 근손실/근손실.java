import java.io.*;
import java.util.*;

public class Main{
    static int n, k;
    static int answer = 0;
    static int a[];
    static boolean used[];
    public static void backtracking(int count, int weight) {
    	if(count == n) {
    		answer++;
    		return;
    	}
    	for(int i = 0 ; i < n; i++) {
    		if(used[i]==true) continue;
    		if(weight+a[i]-k < 500) continue;
    		
    		used[i] = true;
    		backtracking(count+1, weight+a[i]-k);
    		used[i]=false;
    	}
    }
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        a = new int[n];
        used = new boolean[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
        	a[i] = Integer.parseInt(st.nextToken());
        }
        
        backtracking(0,500);
        System.out.println(answer);
    }

}
