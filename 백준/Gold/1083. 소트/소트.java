import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> arr = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        int s = Integer.parseInt(br.readLine());
        //구간을 잡고 교환 횟수 넘지 않게끔 비교해준다. 다음 수보다 크면 바꾸지X, 작으면 바꿈. 
        int count = 0;//교환 횟수
        int moveIdx = 0; 
        while(count < s && moveIdx < n-1) {
        	int maxNum = arr.get(moveIdx), maxIdx = -1; //그 구간에서의 최대 숫자
        	int nextIdx = moveIdx+1, addCount = 1;//몇번 더 움직였는가??
        	while(count+addCount <= s && nextIdx < n) {
        		int now = arr.get(nextIdx);
        		if(now > maxNum) {
        			maxNum = now;
        			maxIdx = nextIdx;
        		}
        		addCount++;
        		nextIdx++;
        	}
        	if(maxIdx != -1) {
        		arr.remove(maxIdx);
        		arr.add(moveIdx, maxNum);
        		count += maxIdx - moveIdx;
        	}
        	moveIdx++;
        }
        for(int nums: arr)
        	System.out.print(nums+" ");
    }
}