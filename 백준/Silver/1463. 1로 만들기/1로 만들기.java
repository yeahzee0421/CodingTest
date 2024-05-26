import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //D[i] = i에서 1로 만드는 데 걸리는 최소 연산 횟수
        /*
         * D[i] = D[i-1]+1 //1을 빼는 연산
         * if(i%2==0) = min(D[i], D[i/2]+1) 2로 나누는 연산
         * if(i%3==0) = min(D[i], D[i/3]+1) 3로 나누는 연산
         */
        
        int n = Integer.parseInt(br.readLine());
        /*
         * 수도코드
         * D[1] = 0 초기화
         * D[i] = D[i-1]+1 //1을 빼는 연산
         * i가 2의 배수일 때 D[i/2]+1이 D[i]보다 작으면 변경 
         * i가 3의 배수일 때 D[i/3]+1이 D[i]보다 작으면 변경 
         */
        int d[] = new int[n+1];
        d[1] = 0;
        for(int i = 2; i <= n; i++) {
        	d[i] = d[i-1]+1;
        	if(i%2==0) d[i] = Math.min(d[i], d[i/2]+1);
        	if(i%3==0) d[i] = Math.min(d[i], d[i/3]+1);
        }
        System.out.println(d[n]);
    }
}
