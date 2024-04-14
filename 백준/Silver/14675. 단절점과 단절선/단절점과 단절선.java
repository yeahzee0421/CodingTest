import java.io.*;
import java.util.*;

public class Main {
	static List<Integer>[] li;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		li = new ArrayList[n+1];
		for(int i=1; i < n+1; i++) {
			li[i] = new ArrayList<>();
		}
		
		for(int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			li[a].add(b);
			li[b].add(a);
		}
		
		//t=1: k번 정점이 단절점인지
		//t=2: k번째 간선이 단절선인지 
		/*
		 * 간선이 없어지는 경우: 그래프 무조건 2개로 나뉨 
		 * 노드가 없어지는 경우: 연결되어 있는 간선의 갯수로 판단.
		 * 해당 정점이 없어지면 정점의 간선 갯수만큼 그래프 생성 
		 * 리프 노드: 간선이 1개 -> 한개의 그래프 생성
		 */
		int q = Integer.parseInt(br.readLine()); //질의의 개수
		for(int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			if(t == 2) {
				sb.append("yes\n");
			}else {
				int k = Integer.parseInt(st.nextToken());
				if(li[k].size() > 1) sb.append("yes\n");
				else sb.append("no\n");
			}
		}
		System.out.println(sb);
	}
	
	
}