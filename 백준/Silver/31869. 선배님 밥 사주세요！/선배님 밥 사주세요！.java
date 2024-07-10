import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        
        Map<String, List<int[]>> promises = new HashMap<>();
        Map<String, Integer> costMap = new HashMap<>(); //선배들 예산
        
        //기록의 정보
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	String s = st.nextToken();
        	int w = Integer.parseInt(st.nextToken()); //w주차
        	int d = Integer.parseInt(st.nextToken()); //요일 0~6
        	int p = Integer.parseInt(st.nextToken()); //예산
        	int day = (w-1)*7+d;
        	
        	if (!promises.containsKey(s)) {
                promises.put(s, new ArrayList<>());
            }
        	
        	 promises.get(s).add(new int[]{day, p});
        }
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	String name = st.nextToken(); //선배이름
        	int m = Integer.parseInt(st.nextToken()); //돈
        	costMap.put(name, m);
        }
        
        List<Integer> days = new ArrayList<>();
        
        for (String name : promises.keySet()) {
            List<int[]> promiseList = promises.get(name);
            int availableMoney = costMap.get(name);
            
            for (int[] promise : promiseList) {
                int day = promise[0];
                int cost = promise[1];
                
                if (availableMoney >= cost && !days.contains(day)) {
                    days.add(day);
                }
            }
        }
        
        Collections.sort(days);
        
        int maxDays = 0;
        int prev = -1;
        int current = 0;
        
        for(int day: days) {
        	if(day == prev+1) {
        		 current++;
        	}
        	else {
        		 current=1;
        	}
        	maxDays = Math.max(maxDays, current);
        	prev = day;
        }
        System.out.println(maxDays);
    }

}