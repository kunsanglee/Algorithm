package practice.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_11052_카드구매하기 {

    static int[] arr = new int[1001];
    static int[] cal = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        /**
         * 1장 살때 최대값 d[1] = 1장 비용(arr[1])
         * 2장 살때 최대값 d[2] = 2장 비용(arr[2]) or 1장 최대값(d[1]) + 1장 비용(arr[1])
         * 3장 살때 최대값 d[3] = 3장 비용(arr[3]) or 2장 최대값(d[2]) + 1장 비용(arr[1]) or 1장 최대값(d[1]) + 2장 비용(arr[2])
         * ...          d[3] = Math.max(arr[3], d[1] + arr[2] or d[2] + arr[1])
         * ...          d[n] = Math.max(arr[n], d[n-2] + arr[n-1] or d[n-1] + arr[n-2])
         */
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            for (int j = 1; j <= i; j++) {
                cal[i] = Math.max(cal[i], cal[i-j] + arr[j]);
                // cal[1] = cal[1], cal[0] + arr[1]
                // cal[2] = cal[2], cal[1] + arr[1], cal[0] + arr[2]
            }
        }

        System.out.println(cal[n]);
    }
}
