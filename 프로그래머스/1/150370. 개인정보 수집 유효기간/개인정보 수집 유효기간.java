import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        
        int year = Integer.parseInt(today.split("\\.")[0]);
        int month = Integer.parseInt(today.split("\\.")[1]);
        int day = Integer.parseInt(today.split("\\.")[2]);
        
        for (int i = 0; i < terms.length; i++) {
            map.put(terms[i].split(" ")[0], terms[i].split(" ")[1]);
        }
        
        //약관 정보 
        for (int i = 0; i < privacies.length; i++) {
            String current = privacies[i].split(" ")[0];
            int len = Integer.parseInt(map.get(privacies[i].split(" ")[1]))*28;

            int totalDays = (year - Integer.parseInt(current.split("\\.")[0]))*28*12 //1년: 28일*12달 
                    + (month - Integer.parseInt(current.split("\\.")[1]))*28 //1달: 28일
                    + (day - Integer.parseInt(current.split("\\.")[2]));

            if (totalDays >= len) {
                answer.add(i+1);
            }
        }
        return answer.stream().filter(i -> i != null).mapToInt(i -> i).toArray();
    }
}