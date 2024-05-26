import java.io.*;
import java.util.*;

public class Main {
    
	static int n;
	static int d[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        /*
         * t: 상담을 완료하는데 걸리는 기간
         * p: 상담 했을 때 받을 수 있는 금액 
         * d[i]: i번째 날부터 퇴사날까지 벌 수 있는 최대 수익 
         * 
         * 두가지 경우가 있다.
         * d[i] = d[i+1] //오늘 시작하는 상담했을 때 퇴사일까지 끝나지 않는 경우
         * d[i] = max(d[i+1], d[i+t[i]]+p[i])//오늘 시작하는 상담했을 때 퇴사일 안에 끝내는 경우 
         * 
         * d[7]=d[6]=0
         * d[5] = max(d[6], d[5+t[5]]+p[5]) = 15
         * d[4] = max(d[5], d[4+t[4]]+p[4]) = 35
         * d[3] = max(d[4], d[3+t[3]]+p[3]) = 45
         * d[2] = max(d[3], d[2+t[2]]+p[2]) = 45
         * d[1] = max(d[2], d[1+t[1]]+p[1]) = 45
         * 
         * d[1]
         */
        n = Integer.parseInt(br.readLine());
        d = new int[n+2];
        int t[] = new int[n+1];
        int p[] = new int[n+1];
        
        for (int i = 1; i <= n; i++) {
        	st = new StringTokenizer(br.readLine());
        	t[i] = Integer.parseInt(st.nextToken());
        	p[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = n; i >= 1; i--) {
        	if(i+t[i] > n+1) {
        		d[i] = d[i+1];
        	}
        	else {
        		d[i] = Math.max(d[i+1], d[i+t[i]]+p[i]);
        	}
        }
        System.out.println(d[1]);
    }
}
