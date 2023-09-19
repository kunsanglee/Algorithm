package practice.백준.bfs_dfs.gold.연구소_14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, MAX;
    static int[][] originMap;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        MAX = Integer.MIN_VALUE;
        originMap = new int[N][M];
        setOriginMap(br);
        dfs(0);
        System.out.println(MAX);
    }

    private static void dfs(int wallCount) {
        if (wallCount == 3) {
            bfs();
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (originMap[i][j] == 0) {
                    originMap[i][j] = 1;
                    dfs(wallCount + 1);
                    originMap[i][j] = 0;
                }
            }
        }
    }


    private static void bfs() {
        Queue<int[]> queue = setVirusQueue();
        int[][] copyMap = copyOriginMap();

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int y = poll[0];
            int x = poll[1];
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (0 <= ny && ny < N && 0 <= nx && nx < M) {
                    if (copyMap[ny][nx] == 0) {
                        queue.offer(new int[]{ny, nx});
                        copyMap[ny][nx] = 2;
                    }
                }
            }
        }

        countSafeZone(copyMap);
    }

    private static void countSafeZone(int[][] copyMap) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) count++;
            }
        }
        MAX = Math.max(MAX, count);
    }

    private static int[][] copyOriginMap() {
        int[][] copyMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            copyMap[i] = originMap[i].clone();
        }
        return copyMap;
    }

    private static Queue<int[]> setVirusQueue() {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (originMap[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        return queue;
    }

    private static void setOriginMap(BufferedReader br) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                originMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
