import java.io.*;
import java.util.*;

public class Main{
    static int n, m, answer;
    static int a[];
    public static void backtracking(int size, int pos, int time) {
    	if(pos == n || time == m) {
    		answer = Math.max(answer, size);
    		return;
    	}
    	for(int i = 1; i <= 2; i++) {
    		if(i==1) backtracking(size+a[pos+i], pos+i, time+1);
    		else backtracking((size/2)+a[pos+i], pos+i, time+1);
    	}
    }
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = 0;
        a = new int[101];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
        	a[i] = Integer.parseInt(st.nextToken());
        }
        backtracking(1, 0, 0);
        System.out.println(answer);
    }

}
