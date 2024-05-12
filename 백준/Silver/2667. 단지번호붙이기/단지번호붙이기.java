import java.io.*;
import java.util.*;

public class Main {
    static int dy[] = {1, -1, 0, 0}; // 상하좌우
    static int dx[] = {0, 0, -1, 1};
    static int n;
    static int map[][];
    static boolean visited[][];
    static ArrayList<Integer> li;
    static Queue<house> q = new LinkedList<house>();

    static class house {
        int x;
        int y;
        int number; // 단지번호

        public house(int y, int x, int number) {
            this.y = y;
            this.x = x;
            this.number = number; // 단지 번호
        }
    }

    static void bfs(int y, int x, int number) {
        Queue<house> queue = new LinkedList<>();
        queue.offer(new house(y, x, number));
        visited[y][x] = true;

        int count = 1; // 현재 단지에 속하는 집 개수

        while (!queue.isEmpty()) {
            house currentHouse = queue.poll();
            int cy = currentHouse.y;
            int cx = currentHouse.x;

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny >= 0 && nx >= 0 && ny < n && nx < n) {
                    if (map[ny][nx] == 1 && !visited[ny][nx]) {
                        queue.offer(new house(ny, nx, number));
                        visited[ny][nx] = true;
                        count++;
                    }
                }
            }
        }
        li.add(count);
        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];
        li = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = input.charAt(j)-'0';
            }
        }

        int number = 0; // 단지 번호

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, ++number); 
                }
            }
        }
        System.out.println(number);
        Collections.sort(li);
        for(int i = 0; i < li.size(); i++) {
        	System.out.println(li.get(i));
        }
    }
}
