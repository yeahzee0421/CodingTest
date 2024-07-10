import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int k = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int len = str.length();
        char[][] map = new char[len / k][k];

        for (int i = 0; i < len / k; i++) {
            map[i] = str.substring(i * k, (i + 1) * k).toCharArray();
            if (i % 2 != 0) {
                reverse(map[i]);
            }
        }

        for (int j = 0; j < k; j++) {
            for (int i = 0; i < len / k; i++) {
                sb.append(map[i][j]);
            }
        }

        System.out.println(sb.toString());
    }

    private static void reverse(char[] map) {
        int left = 0, right = map.length - 1;
        while (left < right) {
            char temp = map[left];
            map[left] = map[right];
            map[right] = temp;
            left++;
            right--;
        }
    }
}
