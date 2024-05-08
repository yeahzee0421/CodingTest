import java.io.*;
import java.util.*;

public class Main{
	static int D[];
	static int S[];
	static int mix[];
	static int n;
	static int k;
    
	static void shuffle() {
		mix = new int[n+1];
		for(int i = 1; i <= n; i++) {
			mix[D[i]] = S[i];
		}
		S = mix;
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken()); //카드 개수
        k = Integer.parseInt(st.nextToken()); //k번 셔플, 즉 카드를 섞은 횟수 
        S = new int[n+1]; //k번 카드를 섞은 후 카드의 배치
        D = new int[n+1]; //주어진 카드 
        
        //입력
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) { 
        	S[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
        	D[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 1; i <= k; i++) {
        	shuffle();
        }
        
        for(int i = 1; i <= n; i++) {
        	System.out.printf(S[i] + " ");
        }
    }

}
