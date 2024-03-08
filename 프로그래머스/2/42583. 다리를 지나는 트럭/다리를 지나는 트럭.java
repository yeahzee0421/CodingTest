import java.util.*;
import java.io.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> cross= new LinkedList<>();   
        Queue<Integer> distance= new LinkedList<>(); 
        List<Integer> wait =  new ArrayList<>(); 
        
        for(int t: truck_weights)
        	wait.add(t);
        
        int currentWeight = 0;
        while(true) {
        	int dis = distance.size();
        	for(int i = 0; i < dis; i++) {
        		int remain_dis = distance.poll();
        		if(remain_dis <= 1) {
        			currentWeight -= cross.poll();
        			continue;
        		}
        		distance.add(remain_dis-1);
        	}
        	if(wait.size() > 0 && currentWeight + wait.get(0) <= weight) {
        		cross.add(wait.get(0));
        		currentWeight += wait.get(0);
        		distance.add(bridge_length);
                wait.remove(0);
        	}
        	answer++;
        	if(wait.isEmpty() && cross.isEmpty()) break;
        }
        return answer;
    }
}