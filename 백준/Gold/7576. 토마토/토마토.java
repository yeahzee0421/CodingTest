import java.io.*;
import java.util.*;

public class Main {
	//창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수
	//모든 토마토가 익어있는 상태이면 0을 출력해야 하고, 토마토가 모두 익지는 못하는 상황이면 -1 출력
	//정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸
	
	static int arr[][];
	static int dirY[] = {1, -1, 0, 0};
	static int dirX[] = {0, 0, -1, 1}; 
	static int m, n = 0;
	public static Queue<tomato> q = new LinkedList<tomato>();
	
	static class tomato{
		int x;
        int y;
        int count;
        public tomato(int y, int x, int count){
            this.y = y;
            this.x = x;
            this.count = count;
        }
	}
	
	public static void solution() {
		int count = 0;
		while(!q.isEmpty()) {
			tomato to = q.poll();
			count = to.count;
			for(int d = 0; d < 4; d++) {
				int mx = to.x + dirX[d];
				int my = to.y + dirY[d];
				if(mx < m && my < n && my >= 0 && mx >= 0) {
					if(arr[my][mx] == 0) {
						arr[my][mx] = 1;
						q.add(new tomato(my, mx,count+1));
					}
				}
			}
		}
		boolean isPossible = true;
		for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr[i][j] == 0) {
                	isPossible = false;
                }
                
            }
        }
		if(isPossible) {
			System.out.println(count);
		}else {
			System.out.println("-1");
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		arr = new int [n][m];

		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) {
					q.offer(new tomato(i,j,0));
				}
			}
		}
		solution();
		
	}
	
	
}