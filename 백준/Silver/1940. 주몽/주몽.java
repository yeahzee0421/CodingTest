import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int start = 0; //index
        int end = n-1;
        int count = 0;
        int sum = 0;
        
        Arrays.sort(arr);
        
        while(start < end) {
        	sum = arr[start]+arr[end];
        	if(sum < m) {
        		start++;
        	}
        	else if(sum == m) {
        		count++;
        		start++;
        		end--;
        	}
        	else {
        		end--;
        	}
        }
        System.out.println(count);
    }
}
