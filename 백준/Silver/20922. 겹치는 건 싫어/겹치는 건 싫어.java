import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] check = new int[100001]; // 각 숫자의 등장 횟수를 저장하는 배열
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int start = 0, end = 0, max = 0;
        while(end < n) {
            if(check[arr[end]] < k) {
                check[arr[end]]++;
                end++;
            } else {
                
                check[arr[start]]--;
                start++;
            }
            max = Math.max(max, end - start);
        }
        System.out.println(max);
    }
}
