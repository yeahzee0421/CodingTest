import java.io.*;
import java.util.*;

public class Main{
	public static int[] arr;
	public static boolean[] visit;
	//고른 수열은 오름차순이어야 한다.
	
	public static void dfs(int n, int m, int start, int dep) {
		if(dep == m) { //depth가 m일때 return하고 val 
			for(int val: arr) {
				System.out.print(val + " ");
			}
			System.out.println();
			return;
		}
		for(int i = start; i <= n; i++) {
			arr[dep] = i;
			dfs(n, m, i+1, dep+1);
		}
	}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr=new int[m];
        visit = new boolean[n];
        dfs(n, m, 1, 0);
        
    }
}