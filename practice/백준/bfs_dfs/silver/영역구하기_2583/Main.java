package practice.백준.bfs_dfs.silver.영역구하기_2583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<int[]> queue = new LinkedList<>();
    static ArrayList<Integer> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        setMap(br, K);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    bfs(i, j, 1);
                }
            }
        }
        result.sort(Integer::compareTo);
        System.out.println(result.size());
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    private static void bfs(int y, int x, int count) {
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = curr[0] + dy[i];
                int nx = curr[1] + dx[i];
                if (ny < 0 || nx < 0 || N <= ny || M <= nx) continue;
                if (!visited[ny][nx] && map[ny][nx] == 0) {
                    visited[ny][nx] = true;
                    queue.offer(new int[]{ny, nx});
                    count++;
                }
            }
        }
        if (count != 0) {
            result.add(count);
        }
    }

    private static void setMap(BufferedReader br, int K) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y = y2 - y1;
            int x = x2 - x1;
            for (int n = y1; n < y1+y; n++) {
                for (int m = x1; m < x1+x; m++) {
                    visited[n][m] = true;
                    map[n][m] = 1;
                }
            }
        }
    }
}
