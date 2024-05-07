import java.io.*;
import java.util.*;

public class Main{
	static char[][] map;
	static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
       
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int up = r; // 위
        int down = 0; // 아래
        int left = c; // 왼쪽
        int right = 0; // 오른쪽
        map = new char[r][c];
        //'X'는 땅을 나타내고, '.'는 바다를
        for(int i = 0; i < r; i++) {
        	String input = br.readLine();
        	for(int j = 0; j < c; j++) {
        		map[i][j] = input.charAt(j);
        	}
        }
        for(int i = 0; i < r; i++) {
        	for(int j = 0; j < c; j++) {
        		if(map[i][j] == 'X') {
        			count = 0;
        			 for (int k = 0; k < 4; k++) {
                         int mx = j + dx[k];
                         int my = i + dy[k];
                         if (mx >= 0 && my >= 0 && my < r && mx < c) { 
                             if (map[my][mx] == '.') {
                                 count++;
                             }
                         } else {
                             count++;
                         }
                     }
                     if (count >= 3) { 
                        map[i][j] = 'S';
                     }
                     if (map[i][j] == 'X') { // 지도의 가장 위, 아래, 왼쪽, 오른쪽 의 좌표를 갱신
                         up = Math.min(up, i);
                         down = Math.max(down, i);
                         left = Math.min(left, j);
                         right = Math.max(right, j);
                     }
        		}
        	}
        }
        for (int i = up; i <= down; i++) {
            for (int j = left; j <= right; j++) {
                char now = map[i][j];
                if (now == 'X') {
                    bw.write(now);
                } else {
                    bw.write('.');
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}