package practice.백준.bfs_dfs.silver.케빈베이컨의6단계법칙_1389;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static Map<Integer, ArrayList<Integer>> relationship = new HashMap<>();
    public static void main(String[] args) throws IOException {
        // N 유저의 수 , M 친구 관계 수
        // 1~N 의 번호를 갖는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        setRelation();
        connectRelation(br);

        int minKevinBacon = Integer.MAX_VALUE; // 최소 케빈 베이컨의 수
        int minUser = 0; // 최소 케빈 베이컨의 수를 가진 유저 번호

        for (int i = 1; i <= N; i++) {
            int count = bfs(i);
            if (count < minKevinBacon) {
                minKevinBacon = count;
                minUser = i;
            }
        }

        System.out.println(minUser);
    }

    private static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        int[] kevinBacon = new int[N + 1];

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int friend : relationship.get(current)) {
                if (!visited[friend]) {
                    visited[friend] = true;
                    queue.offer(friend);
                    kevinBacon[friend] = kevinBacon[current] + 1;
                }
            }
        }

        int totalKevinBacon = 0;
        for (int i = 1; i <= N; i++) {
            totalKevinBacon += kevinBacon[i];
        }

        return totalKevinBacon;
    }

    private static void connectRelation(BufferedReader br) throws IOException {
        StringTokenizer st;
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            relationship.get(x).add(y);
            relationship.get(y).add(x);
        }
    }

    private static void setRelation() {
        for (int i = 1; i <= N; i++) {
            relationship.put(i, new ArrayList<>());
        }
    }
}
