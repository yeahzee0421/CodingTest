import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<int[]> timeList = new ArrayList<>();
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int[] time = new int[2];
            time[0] = Integer.parseInt(st.nextToken());    
            time[1] = Integer.parseInt(st.nextToken()); 
            timeList.add(time);
        }
        timeList.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int count = 0;
        int prev_end_time = 0;

        for (int[] time : timeList) {
            if (prev_end_time <= time[0]) {
                prev_end_time = time[1];
                count++;
            }
        }
        System.out.println(count);
    }
}