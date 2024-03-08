import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int pokemon = nums.length/2;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++) {
        	set.add(nums[i]);
        }
        int count = 0;
        for(int n: set) {
        	count++;
        	if(count == pokemon) break;
        }
        answer = count;
        return answer;
    }
}