import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*
         * D[n][2], 0으로 끝나는 경우와 1로 끝나는 경우를 나누어 생각한다. 
         * D[i][0]: i 길이에서 끝이 0으로 끝나는 이친수의 개수
         * D[i][1]: i 길이에서 끝이 1로 끝나는 이친수의 개수 
         * 0으로 끝나는 경우: 이전 단계의 0과 1로 끝나는 것 모두 붙일 수 있다.=>D[i][0] = D[i-1][1]+D[i-1][0]
         * 1로 끝나는 경우: 이전 단계에서 0으로 끝나는 것만 붙일 수 있다.=>D[i][1] += D[i-1][0]
         * 구하는 값 D[5][0]+D[5][1]
         */
        
        int n = Integer.parseInt(br.readLine());
        long d[][] = new long[n+1][2];
        d[1][1] = 1;
        d[1][0] = 0;
        for(int i = 2; i <= n; i++) {
        	d[i][0] = d[i-1][1] + d[i-1][0];
        	d[i][1] = d[i-1][0];
        }
        
        System.out.println(d[n][0]+d[n][1]);
    }
}
