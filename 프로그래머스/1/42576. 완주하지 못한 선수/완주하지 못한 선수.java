import java.io.*;
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        
        for(String who: participant) 
        	map.put(who, map.getOrDefault(who, 0)+1);
        
        for(String who: completion)
        	map.put(who, map.get(who)-1);
        
        Iterator <Map.Entry<String, Integer>> it = map.entrySet().iterator();
        while(it.hasNext()) {
        	Map.Entry<String, Integer> entry = it.next();
        	if(entry.getValue()!=0) {
        		answer = entry.getKey();
        		break;
        	}
        }
        return answer;
    }
}