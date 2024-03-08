import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[][] edges) {
        int[] res = new int[4];
        Map<Integer, int[]> map = new HashMap<>();
        
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            //만약 x,y에 대한 정보 X -> 0으로 초기화 해주기 
            if (!map.containsKey(x))
                map.put(x, new int[]{0, 0});
            if (!map.containsKey(y))
                map.put(y, new int[]{0, 0});
            map.get(x)[0]++;//x번 노드의 out이 +1
            map.get(y)[1]++; //y번 노드의 in이 +1
        }
        
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int node = entry.getKey();
            int[] items = entry.getValue();
            int out = items[0];
            int in = items[1];
            if (out >= 2 && in == 0)
                res[0] = node; //생성한 정점 
            else if (out >= 2 && in >= 2)
                res[3]++; //8자
            else if (out == 0 && in >= 1)
                res[2]++; //막대
        }
        //생성한 정점에서 나가는 간선 수 = 총 그래프의 수
        int graphCount = map.get(res[0])[0]; 
        res[1] = graphCount - res[2] - res[3]; 
        return res;
    }
}