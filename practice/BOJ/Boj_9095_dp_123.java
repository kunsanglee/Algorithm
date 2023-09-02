package practice.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Boj_9095_dp_123 {

    public static int[] arr = new int[12];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            for (int j = 4; j <= x; j++) {
                arr[j] = arr[j-1] + arr[j-2] + arr[j-3];
            }
            System.out.println(arr[x]);
        }
    }
}
