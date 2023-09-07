package practice.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15651_N과M_3 {

    static int N, M;
    static int[] selected;
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M + 1];
        recursive(1);
        System.out.println(sb.toString());
    }

    private static void recursive(int k) {
        if (k > M) {
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int cand = 1; cand <= N; cand++) {
            selected[k] = cand;
            recursive(k + 1);
            selected[k] = 0;
        }
    }
}
