package practice.백준.bfs_dfs.gold.벽부수고이동하기_2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x, y, wallCnt, distance;

    public Point(int x, int y, int wallCnt, int distance) {
        this.x = x;
        this.y = y;
        this.wallCnt = wallCnt;
        this.distance = distance;
    }
}

public class Main {
    static int[][] map;
    static int[][][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new int[N][M][2]; // 벽을 부순 경우와 부수지 않은 경우를 저장

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
                visited[i][j][0] = Integer.MAX_VALUE; // 방문한 적 없는 경우를 MAX_VALUE 표시.
                visited[i][j][1] = Integer.MAX_VALUE;
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0, 0, 1));
        visited[0][0][0] = 1;

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            int x = current.x;
            int y = current.y;
            int wallCnt = current.wallCnt;
            int distance = current.distance;

            if (x == N - 1 && y == M - 1) {
                return distance;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (map[nx][ny] == 0 && visited[nx][ny][wallCnt] > distance + 1) { // 벽이 아니고, 벽을 부쉈든 안부쉈든 방문하지 않은 경우
                        visited[nx][ny][wallCnt] = distance + 1;
                        queue.offer(new Point(nx, ny, wallCnt, distance + 1));
                    } else if (map[nx][ny] == 1 && wallCnt == 0 && visited[nx][ny][1] > distance + 1) { // 벽을 만났고, 벽을 부순적이 없고, 방문하지 않은 경우
                        visited[nx][ny][1] = distance + 1;
                        queue.offer(new Point(nx, ny, 1, distance + 1));
                    }
                }
            }
        }

        return -1; // 도달할 수 없는 경우
    }
}
