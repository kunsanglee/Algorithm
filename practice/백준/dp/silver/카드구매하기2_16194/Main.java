package practice.백준.dp.silver.카드구매하기2_16194;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr = new int[1001];
    static int[] cal = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            cal[i] = arr[i];
            for (int j = 1; j <= i; j++) {
                cal[i] = Math.min(cal[i], cal[i - j] + arr[j]);
            }
        }
        System.out.println(cal[n]);

    }
}
