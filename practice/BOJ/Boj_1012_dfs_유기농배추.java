package practice.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1012_dfs_유기농배추 {

    static int[][] arr;
    static boolean[][] visited;
    static int[] xDirection = {0, 0, -1, 1};
    static int[] yDirection = {-1, 1, 0, 0};
    static int count = 0;


    private static void dfsFunc(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nextX = x + xDirection[i];
            int nextY = y + yDirection[i];
            if (isPosition(nextX, nextY) && !visited[nextX][nextY] && arr[nextX][nextY] == 1) {
                dfsFunc(nextX, nextY);
            }
        }
    }

    private static boolean isPosition(int x, int y) {
        if (0 <= x && x < arr.length && 0 <= y && y < arr[0].length) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            arr = new int[x][y];
            visited = new boolean[x][y];
            for (int m = 0; m < k; m++) {
                st = new StringTokenizer(br.readLine());
                int by = Integer.parseInt(st.nextToken());
                int bx = Integer.parseInt(st.nextToken());
                arr[bx][by] = 1;
            }

            count = 0;
            for (int m = 0; m < x; m++) {
                for (int p = 0; p < y; p++) {
                    if (!visited[m][p] && arr[m][p] == 1) {
                        dfsFunc(m, p);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
