import java.io.*;
import java.util.*;

public class Main{
    static int n, k;
    static int[] arr;
    static boolean[] visit; //1,2,3 방문했는지 체크 
    static int count;
    
    static void sol(int weight, int pos) {
        if (pos == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i] && (weight + arr[i] - k) >= 500) {
                visit[i] = true;
                sol(weight + arr[i] - k, pos + 1);
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        visit = new boolean[n];
        count = 0;
        sol(500, 0);
        System.out.println(count);
    }
}