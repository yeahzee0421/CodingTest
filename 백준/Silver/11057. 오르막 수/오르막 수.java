import java.io.*;

/*
길이 N이고, 마지막 자리가 k인 숫자 개수를 구하기 위해
길이가 N-1 인 수 중에서, 가장 마지막 자리가 k 이하인 숫자들의 수를 합한 값
dp[N][k] = sum(dp[N-1][0...k]) 
 */
public class Main {
	public static void solution(int n, int dp[][]) {
		for(int i = 0; i < 10; i++) {
			dp[0][i] = 1;
		}
		for(int i = 1; i <= n; i++) {
			for(int j = 0; j < 10; j++) {
				for(int k = j; k < 10; k++) {
					dp[i][j] += dp[i-1][k];
					dp[i][j] %= 10007;
				}
			}
		}
		System.out.println(dp[n][0]%10007);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int dp[][] = new int[n+1][10]; //0~9 
		solution(n, dp);
	}
}