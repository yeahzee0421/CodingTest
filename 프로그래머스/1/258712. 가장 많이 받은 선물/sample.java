// 2차원 배열을 사용한 방법
// 주어진 예시를 토대로 그대로 구현하는 방법인데 훨씬 간단해 보인다. 참고하면 좋을듯 

import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            map.put(friends[i], i);
        }
        int[] index = new int[friends.length];
        int[][] record = new int[friends.length][friends.length];

        for (String str : gifts) {
            String[] cur = str.split(" ");
            index[map.get(cur[0])]++;
            index[map.get(cur[1])]--;
            record[map.get(cur[0])][map.get(cur[1])]++;
        }

       int ans = 0;
       for (int i = 0; i < friends.length; i++) {
           int cnt = 0;
           for (int j = 0; j < friends.length; j++) {
               if(i == j) continue;
               if (record[i][j] > record[j][i]) cnt++;
               else if (record[i][j] == record[j][i] && index[i] > index[j]) cnt++; 
           }
           ans = Math.max(cnt, ans);
       }
        return ans;
    }
}
