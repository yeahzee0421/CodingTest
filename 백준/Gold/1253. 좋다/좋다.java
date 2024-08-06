import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
      int n = Integer.parseInt(br.readLine());
      long A[] = new long[n];
      int answer = 0;
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      for(int i = 0; i < n; i++) {
    	  A[i] = Integer.parseInt(st.nextToken());
      }
      
      Arrays.sort(A); //A 정렬 
      //찾고자하는 값 find, 포인터 start, 포인터 end 
      for(int k = 0; k < n; k++) {
    	  long find = A[k];
    	  int s = 0; //포인터1(index)
    	  int e = n-1; //포인터2(index)
    	  
    	  while(s < e) {
    		  if(A[s]+A[e] == find){ //두 합이 find와 같고,
    			  if(s != k && e != k) { //다른 수인가? 체크
    				  answer++;
    				  break;
    			  } else if(s==k) { //s가 다르다면
    				  s++; //s증가
    			  } else if(e==k) {
    				  e--; //e감소
    			  }
    		  } else if(A[s]+A[e] < find) {
    			  s++;
    		  } else {
    			  e--;
    		  }
    		  
		  }
	  }
      System.out.println(answer);
        
    }
}
