import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       
       int n = Integer.parseInt(st.nextToken());
       int k = Integer.parseInt(st.nextToken());
       int arr[] = new int[n];
       int max = 0;
       
       for(int i = 0; i < n; i++) {
    	   arr[i] = Integer.parseInt(br.readLine());
    	   max = Math.max(max, arr[i]);
       }
       
       long s = 1;
       long e = max;
       long res = 0;
       
       while(s <= e) {
    	   int tmp = 0;
    	   long mid = (s+e)/2;
    	   for(int i = 0; i < n; i++) {
    		   tmp += (arr[i]/mid);
    	   }
    	   if(tmp >= k) {
    		   res = mid;
    		   s = mid+1;
    	   }else {
    		   e = mid-1;
    	   }
    	   
       }
       System.out.println(res);
        
    }
}
