import java.io.*;
import java.util.*;

public class Main{
    static int dy[] = {1,-1,0,0};
    static int dx[] = {0,0,1,-1};
    static int n, m;
    static int map[][];
    static boolean visited[][];
    
    static class point{
        int x;
        int y;
        int count; // 각 위치까지의 카운트를 저장할 변수
        public point(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }
    
    static void bfs(int x, int y) {
        Queue<point> q = new LinkedList<>();
        q.offer(new point(y,x,1)); 
        visited[y][x]=true;
        
        while(!q.isEmpty()) {
            point currentPoint = q.poll();
            int cy = currentPoint.y;
            int cx = currentPoint.x;
            int count = currentPoint.count; //현재 위치까지 칸수 
            
            if(cy == n-1 && cx == m-1) {
                System.out.println(count); 
                return;
            }
            
            for(int d = 0; d < 4; d++) {
                int ny = cy + dy[d];
                int nx = cx + dx[d];
                if(ny >= 0 && nx >= 0 && ny < n && nx < m) {
                	if(map[ny][nx] == 1 && !visited[ny][nx]) {
                		q.offer(new point(ny,nx,count+1));
                        visited[ny][nx] = true;
                	}
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        visited = new boolean[n][m];
        
        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            for(int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j)-'0';
            }
        }
        bfs(0,0);
    }
}
