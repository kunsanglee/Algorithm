package practice.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15990_1_2_3더하기5 {

    static long[][] arr = new long[100001][4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr[1][1] = 1; // 1
        arr[2][2] = 1; // 2
        arr[3][3] = 1; // 3
        arr[3][1] = 1; // 2+1
        arr[3][2] = 1; // 1+2

        for (int i = 4; i <= 100000; i++) {
            arr[i][1] = (arr[i-1][2] + arr[i-1][3]) % 1000000009;
            arr[i][2] = (arr[i-2][1] + arr[i-2][3]) % 1000000009;
            arr[i][3] = (arr[i-3][2] + arr[i-3][1]) % 1000000009;
        }

        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            System.out.println((arr[k][1]+arr[k][2]+arr[k][3]) % 1000000009);
        }
    }
}
