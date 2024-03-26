import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int A[] = new int[n];
		int dp[] = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) 
			A[i] = Integer.parseInt(st.nextToken());
		dp[0] = 1;

		for (int i = 1; i < n; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (A[j] < A[i] && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
				}
			}
		}

		int answer = 0;
		for (int d : dp) {
			answer = Math.max(answer, d);
		}

		System.out.println(answer);

	}

}