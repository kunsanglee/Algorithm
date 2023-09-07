package practice.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15650_N과M_2 {

    static int N, M;
    static int[] selected;
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M + 1];
        recurse(1);
        System.out.println(sb.toString());
    }

    private static void recurse(int k) {
        if (k > M) {
            completeSelected();
            return;
        }
        for (int candidate = 1; candidate <= N; candidate++) {
            if (selected[k-1] < candidate) {
                setSelected(k, candidate);
            }
        }
    }

    private static void completeSelected() {
        for (int i = 1; i <= M; i++) {
            sb.append(selected[i]).append(" ");
        }
        sb.append("\n");
    }

    private static void setSelected(int k, int candidate) {
        selected[k] = candidate;
        recurse(k + 1);
        selected[k] = 0;
    }
}
