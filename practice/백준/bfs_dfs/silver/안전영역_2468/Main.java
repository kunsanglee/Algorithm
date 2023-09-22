package practice.백준.bfs_dfs.silver.안전영역_2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, target, maxCount;
    static final int maxRainHeight = 100;
    static int[][] map;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        target = 0;
        maxCount = Integer.MIN_VALUE;
        map = new int[N][N];
        setMap(br);
        while (target < maxRainHeight) {
            boolean[][] visited = new boolean[N][N];
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && target < map[i][j]) {
                        queue.offer(new int[]{i, j});
                        visited[i][j] = true;
                        count++;
                        bfs(visited);
                    }
                }
            }
            maxCount = Math.max(maxCount, count);
            target++;
        }
        System.out.println(maxCount);
    }

    private static void bfs(boolean[][] visited) {
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int k = 0; k < dy.length; k++) {
                int ny = poll[0] + dy[k];
                int nx = poll[1] + dx[k];
                if (ny < 0 || nx < 0 || N <= ny || N <= nx) continue;
                if (!visited[ny][nx] && target < map[ny][nx]) {
                    queue.offer(new int[]{ny, nx});
                    visited[ny][nx] = true;
                }
            }
        }
    }

    private static void setMap(BufferedReader br) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
