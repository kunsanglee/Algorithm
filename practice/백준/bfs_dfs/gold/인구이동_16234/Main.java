package practice.백준.bfs_dfs.gold.인구이동_16234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, L, R, days;
    static int[][] country;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        country = new int[N][N];
        visited = new boolean[N][N];
        setCountry(br);

        boolean moved; // 인구 이동이 하루 동안 발생했는지 확인하는 변수

        while (true) {
            moved = false;
            visited = new boolean[N][N]; // 매일매일 visited 배열 초기화
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        if (bfs(i, j)) {
                            moved = true;
                        }
                    }
                }
            }
            if (!moved) {
                break;
            }
            days++;
        }

        System.out.println(days);
    }

    private static boolean bfs(int y, int x) {
        int total = 0;
        int count = 0;
        ArrayList<int[]> list = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y, x});
        visited[y][x] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            y = current[0];
            x = current[1];
            list.add(new int[]{y, x});
            total += country[y][x];
            count++;
            for (int i = 0; i < dx.length; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx]) continue;
                int diff = Math.abs(country[y][x] - country[ny][nx]);
                if (L <= diff && diff <= R) {
                    queue.offer(new int[]{ny, nx});
                    visited[ny][nx] = true;
                }
            }
        }
        if (count != 1) {
            int average = total / count;
            for (int i = 0; i < list.size(); i++) {
                int[] current = list.get(i);
                country[current[0]][current[1]] = average;
            }
            return true; // 인구 이동이 발생한 경우 true 반환
        }
        return false; // 인구 이동이 발생하지 않은 경우 false 반환
    }

    private static void setCountry(BufferedReader br) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                country[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
