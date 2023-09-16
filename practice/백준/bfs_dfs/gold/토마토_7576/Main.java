package practice.백준.bfs_dfs.gold.토마토_7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int m, n, days;
    static int[][] box;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        box = new int[n][m];
        visited = new boolean[n][m];
        makeBox(br);
        System.out.println(bfs() - 1);
    }

    private static int bfs() {
        while (!queue.isEmpty()) {
            days++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] tomato = queue.poll(); // 초기 토마토 위치를 뽑는다.
                for (int j = 0; j < 4; j++) { // 발견된 토마토의 상하좌우에 안익은 토마토 찾기.
                    int nextY = tomato[0] + dy[j];
                    int nextX = tomato[1] + dx[j];
                    if (!(0 <= nextX && 0 <= nextY && nextX < m && nextY < n)) continue; // 범위를 벗어나면 건너뛴다.
                    if (visited[nextY][nextX] || box[nextY][nextX] == -1) continue; // 방문했거나, 빈칸이면 건너뛴다.
                    box[nextY][nextX] = days + 1; // 안익은 토마토를 발견한 자리에 일자 + 1 을 해서 체크해준다.
                    visited[nextY][nextX] = true; // 방문처리를 한다.
                    queue.add(new int[]{nextY, nextX}); // 큐에 넣는다.
                }
            }
        }

        // 전체 박스를 돌면서 box[i][j]에 days + 1 만큼 계속 올려줬기 때문에
        // 끊어진 박스가 없다면 0이 아닌 -1 또는 1 이상의 숫자만 있어야 한다.
        // 근데 0인게 있다면? 끊어진 박스. -> -1 반환.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 0) {
                    return - 1;
                }
            }
        }
        return days;
    }

    private static void makeBox(BufferedReader br) throws IOException {
        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if (box[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
    }
}
