import java.io.*;
import java.util.*;

public class Main {
    static class House implements Comparable<House>{
        long pos, val;
        public House(long pos, long val){
            this.pos = pos;
            this.val = val;
        }
        @Override
        public int compareTo(House o) {
            return (int) (this.pos - o.pos);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<House> houseList = new ArrayList<>();
        long sum = 0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            long pos  = Long.parseLong(st.nextToken());
            long val = Long.parseLong(st.nextToken());
            houseList.add(new House(pos, val));
            sum += val;	
        }
        Collections.sort(houseList);	
        long result = 0;
        for(int i=0; i < N; i++){
            result += houseList.get(i).val;
            if((sum + 1)/2 <= result){	
                bw.write(String.valueOf(houseList.get(i).pos));
                break;
            }
        }
        bw.flush();	
        bw.close();
        br.close();
    }
}