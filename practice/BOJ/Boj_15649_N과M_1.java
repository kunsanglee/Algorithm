package practice.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15649_N과M_1 {

    static int N, M;
    static int[] selected, isUsed;
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M + 1];
        isUsed = new int[N + 1];
        recurse(1);
        System.out.println(sb.toString());
    }

    private static void recurse(int k) {
        if (k > M) {
            completeSelected();
            return;
        }
        for (int candidate = 1; candidate <= N; candidate++) {
            if (isUsed(candidate)) continue;
            setSelected(k, candidate);
        }
    }

    private static boolean isUsed(int candidate) {
        return isUsed[candidate] == 1;
    }

    private static void completeSelected() {
        for (int i = 1; i <= M; i++) {
            sb.append(selected[i]).append(" ");
        }
        sb.append("\n");
    }

    private static void setSelected(int k, int candidate) {
        selected[k] = candidate;
        isUsed[candidate] = 1;
        recurse(k + 1);
        selected[k] = 0;
        isUsed[candidate] = 0;
    }
}
