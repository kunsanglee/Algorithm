package practice.백준.bfs_dfs.silver.섬의개수_4963;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, 0, -1, 1};
    static Queue<int[]> queue = new LinkedList<>();
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String str = br.readLine();
            if (str.equals("0 0")) {
                break;
            }
            StringTokenizer st = new StringTokenizer(str);
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int[][] map = new int[h][w];
            visited = new boolean[h][w];
            setMap(br, w, h, map);
            bfs(w, h, map);
        }
    }

    private static void bfs(int w, int h, int[][] map) {
        int count = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    count++;
                }
                while (!queue.isEmpty()) {
                    int[] land = queue.poll();
                    int y = land[0];
                    int x = land[1];
                    for (int k = 0; k < dx.length; k++) {
                        int ny = y + dy[k];
                        int nx = x + dx[k];
                        if (ny < 0 || nx < 0 || h <= ny || w <= nx) continue;
                        if (!visited[ny][nx] && map[ny][nx] == 1) {
                            visited[ny][nx] = true;
                            queue.offer(new int[]{ny, nx});
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }

    private static void setMap(BufferedReader br, int w, int h, int[][] map) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
