package practice.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1149_RGB거리 {

    static int[][] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        cost = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());

            // 2 번째 집 부터는 이전 집의 색 별로 최소값을 누적합하여 나아간다.
            if (i > 0) {
                cost[i][0] += Math.min(cost[i - 1][1], cost[i - 1][2]);
                cost[i][1] += Math.min(cost[i - 1][0], cost[i - 1][2]);
                cost[i][2] += Math.min(cost[i - 1][0], cost[i - 1][1]);
            }
        }

        System.out.println(Math.min(cost[n-1][0], Math.min(cost[n-1][1], cost[n-1][2])));
    }
}
