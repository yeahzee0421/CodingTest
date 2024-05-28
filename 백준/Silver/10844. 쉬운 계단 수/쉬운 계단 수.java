import java.io.*;
import java.util.*;

public class Main {
    /*
     * d[n][h]: 길이가 n인 계단에서 h 높이로 종료되는 계단수를 만들 수 있는 경우의 수 
     * 높이에 따른 점화식
     * d[i][n] = d[i-1][h+1] //h=0
     * d[i][h] = d[i-1][h-1] //h=9
     * d[i][h] = d[i-1][h-1]+d[i-1][h+1] //h=1~8
     * 
     * 각 높이에서 길이가 1인 계단수는 1가지
     * d[1][1~9]=1
     */
	static int n;
	static long d[][];
	static long mod = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine()); //길이 
        d = new long[n+1][9+2];
        for(int i = 1; i <= 9; i++) {
        	d[1][i] = 1; //길이가 1인 계단수는 1가지 
        }
        for(int i = 2; i <= n; i++) {
        	d[i][0] = d[i-1][1];
        	d[i][9] = d[i-1][8];
        	for(int j = 1; j <= 8; j++) {
        		d[i][j] = (d[i-1][j-1] + d[i-1][j+1]) % mod;
        	}
        }
        long sum = 0;
        for(int i = 0; i <= 9; i++) {
        	sum = (sum+d[n][i])%mod;
        }
        System.out.println(sum);
    }
}
