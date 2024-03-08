import java.util.ArrayList;
/*
    직접 네트워크 갯수: edge(간선) 갯수
    간선이 연결되어 있으면 하나의 네트워크임. 
    computer[i][j] = 1이면 인접 노드 ArrayList에 i와 j를 추가 
    그리고 간선 갯수 카운팅 
    */

class Solution {
    
    static ArrayList<Integer>[] A;
    static boolean visited[];
    
    public int solution(int n, int[][] computers) { 
        int answer = 0;
        
        A = new ArrayList[n];
		visited = new boolean[n];
        
         //인접 리스트 초기화 
        for(int i = 0; i < n; i++) {
			A[i] = new ArrayList<Integer>();
		}
        
        /*computers[i][j]가 1이고 i==j가 아닐 때 
        i와 j는 인접하여 있으므로 인접 리스트에 추가해 */ 
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(computers[i][j] == 1 && i != j){
                    A[j].add(i);
                    A[i].add(j);
                }
            }
        }
        
        //노드 갯수만큼 돌려서 edge 갯수 구하면 될듯?
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                answer++;
                DFS(i);
            } 
        }
        return answer;
    }
    
    static void DFS(int node){
        if(visited[node]) return; //종료조건
        visited[node] = true; //방문했으므로 true로 바꿔
        //인접리스트에 있는 요소들을 쭉 반복하면서
        for(int a: A[node]){
            //방문하지 않은 A[node]이면 DFS 재귀 돌려
            if(visited[a] == false) 
                DFS(a);
        }
        
    }
}