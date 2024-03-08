import java.util.*;

class Solution {
    public int[] solution(String[] idList, String[] report, int k){
        int num = idList.length;
        int[] answer = new int[num];
        HashMap<String, HashSet<String>> map = new HashMap<>(); //정보 매핑
    	HashMap<String, Integer> result = new HashMap<>(); //카운팅 해줌 
    	HashSet<String> userSet = new HashSet<>(Arrays.asList(report));
    	
    	for(String user: userSet) {
    		String splited[] = user.split(" ");
    		String id = splited[0];
    		String reported = splited[1];
    		
    		map.putIfAbsent(id, new HashSet<String>() {
    			{ add(reported); }
    		});
    		map.get(id).add(reported);
    		result.put(reported, result.getOrDefault(reported, 0)+1);
    	}

    	for(String who: result.keySet()) {
    		int howmany = result.get(who);
    		if(howmany >= k) {
    			for(int i = 0; i < num; i++) {
    				if(map.containsKey(idList[i]) && map.get(idList[i]).contains(who))
    					answer[i]++;
    			}
    		}
    	}
        return answer;
   }
}