import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	int road[] = new int[n-1];
    	int city[] = new int[n];
    	StringTokenizer st;
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < n-1; i++) // 0 1 2 
    		road[i] = Integer.parseInt(st.nextToken());
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < n; i++) // 0 1 2 3
    		city[i] = Integer.parseInt(st.nextToken());
    	
    	int cost = 0;
    	int min = city[0]; //5
    	//가격에 초점 맞춰 비교 
    	//더 싸네? 여기서 도로 길이만큼 더 넣자
    	for(int i = 0; i < n-1; i++) {
    		if(city[i] < min) {
				min = city[i];
			}
    		cost += (min*road[i]);
    	}
    	System.out.println(cost);
    }
}