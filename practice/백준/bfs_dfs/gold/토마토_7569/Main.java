package practice.백준.bfs_dfs.gold.토마토_7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, H;
    static int[][][] box;
    static boolean[][][] visited;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = {0, 0, 0, 0, -1, 1};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {-1, 1, 0, 0, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        box = new int[H][N][M];
        visited = new boolean[H][N][M];
        setBox(br);

        while (!queue.isEmpty()) {
            int size = queue.size(); // queue의 size를 변수로 빼놓고 그 만큼만 반복문 돌아야함.
            for (int i = 0; i < size; i++) { // 그렇지 않으면 queue에 변동이 생겨서 오동작.
                int[] tomato = queue.poll();
                for (int j = 0; j < 6; j++) { // 상 하 좌 우 앞 뒤 6개 방향 체크
                    int nz = tomato[0] + dz[j];
                    int ny = tomato[1] + dy[j];
                    int nx = tomato[2] + dx[j];
                    if (0 <= nz && 0 <= ny && 0 <= nx && nz < H && ny < N && nx < M) { // 맵의 허용 범위 체크
                        if (!visited[nz][ny][nx] && box[nz][ny][nx] == 0) { // 방문하지 않았고, 안익은 토마토면
                            queue.offer(new int[]{nz, ny, nx});
                            box[nz][ny][nx] = box[tomato[0]][tomato[1]][tomato[2]] + 1;
                            visited[nz][ny][nx] = true;
                        }
                    }
                }
            }
        }
        System.out.println(count());
    }

    private static int count() {
        int maxDays = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (box[i][j][k] == 0) { // 박스에 일차를 더해줬기 때문에 막혀있다면 0 존재.
                        return -1;
                    }
                    maxDays = Math.max(maxDays, box[i][j][k]); // 모든 박스를 돌면서 가장 값이 큰 값 저장.
                }
            }
        }
        return maxDays - 1; // 시작할 때 더한 1일을 빼줘야함.
    }

    private static void setBox(BufferedReader br) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if (box[i][j][k] == 1) {
                        queue.offer(new int[]{i, j, k});
                        visited[i][j][k] = true;
                    }
                }
            }
        }
    }
}
