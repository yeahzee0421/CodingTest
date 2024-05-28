import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int seq[];
	static int right[];
	static int left[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());  
        seq = new int[n];
        right = new int[n];
        left = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
        	seq[i] = Integer.parseInt(st.nextToken());
        }
        
      //왼쪽부터
        left[0] = seq[0];
        int maxValue = left[0];
        for(int i = 1; i < n; i++) {
        	left[i] = Math.max(seq[i], seq[i]+left[i-1]);
        	maxValue = Math.max(maxValue, left[i]);
        }
        
        right[n-1]=seq[n-1];
        //오른쪽부터
        for(int i = n-2; i >= 0; i--) {
        	right[i] = Math.max(seq[i], seq[i]+right[i+1]);
        }
        
        for(int i = 1; i < n-1; i++) {
        	int tmp = left[i-1]+right[i+1];
        	maxValue = Math.max(tmp, maxValue);
        }
        
        bw.write(maxValue+"\n");
        bw.flush();
        bw.close();
        bw.close();
    }
}
