import java.util.Scanner;

public class Main {

    static int[] snow = new int[101]; 
    static int N, M;
    static int answer = 0; 

    public static void func(int time, int size, int pos) {
        if (time == M || pos >= N) { 
            answer = Math.max(size, answer);
            return;
        }

        // 눈덩이를 굴리는 경우, 던지는 경우
        for (int i = 1; i <= 2; i++) {
            if (i == 1) {
                func(time + 1, size + snow[pos + i], pos + i); 
            } else {
                func(time + 1, (size / 2) + snow[pos + i], pos + i); 
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            snow[i] = sc.nextInt();
        }

        func(0, 1, 0);
        System.out.println(answer);

        sc.close();
    }
}
