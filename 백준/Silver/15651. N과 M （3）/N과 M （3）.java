import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] pick;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        pick = new int[M];

        bt(0);
        System.out.println(sb);
    }
    public static void bt(int depth) {
        if(depth == M) {
            for(int i: pick) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++) {
            pick[depth] = i + 1;
            bt(depth + 1);
        }
    }
}