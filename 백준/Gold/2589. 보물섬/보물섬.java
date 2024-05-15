import java.io.*;
import java.util.*;

public class Main{

    static int l, w;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
//    static ArrayList<Integer> li;
    static int answer;

    static class Point { 
        int x;
        int y;
        int count; 

        public Point(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }

    static void bfs(int y, int x, int count) {
    	visited = new boolean[l][w];
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(y, x, count));
        visited[y][x] = true;

        while (!q.isEmpty()) {
            int size = q.size(); 
            for (int i = 0; i < size; i++) {
                Point currentPoint = q.poll();
                int cy = currentPoint.y;
                int cx = currentPoint.x;
                int cCount = currentPoint.count;

                for (int d = 0; d < 4; d++) {
                    int ny = cy + dy[d];
                    int nx = cx + dx[d];
                    if (ny >= 0 && nx >= 0 && ny < l && nx < w) {
                        if (map[ny][nx] == 'L' && !visited[ny][nx]) {
                        	visited[ny][nx] = true;
                            q.offer(new Point(ny, nx, cCount+1));
                            
                            answer = Math.max(answer, cCount+1);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        
        w = Integer.parseInt(st.nextToken());
        map = new char[l][w];
        
        
        answer = 0;

        // 입력받기
        for (int i = 0; i < l; i++) {
            String input = br.readLine();
            for (int j = 0; j < w; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 'L') bfs(i, j, 0); 
            }
        }
        System.out.println(answer);
    }
}
