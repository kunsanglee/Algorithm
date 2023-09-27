package practice.백준.bfs_dfs.gold.아기상어_16236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static class Shark {
        int x;
        int y;
        int size;
        int eatCount;

        public Shark(int x, int y) {
            this.x = x;
            this.y = y;
            this.size = 2;
            this.eatCount = 0;
        }
    }

    static class Fish {
        int x;
        int y;
        int distance;

        public Fish(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    static int N, result;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] map;
    static boolean[][] visited;
    static Shark shark;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        result = 0;
        map = new int[N][N];
        visited = new boolean[N][N];
        setMap(br);
        while (true) {
            Fish target = findTarget();
            if (target == null) break; // 더 이상 먹을 물고기가 없다면 while 종료.
            eatFish(target); // 먹을 수 있는 물고기를 찾은 후 해당 상어가 해당 물고기 위치로 이동하여 해당 위치 빈 공간으로 초기화, 먹은 물고기 수 증가.
            sizeUpAndInitCount(); // 상어의 크기와 먹은 물고기 수가 같으면 상어의 사이즈를 늘리고 먹은 물고기 수 초기화.
            result += target.distance; // 먹은 물고기의 거리만큼 증가.
            visited = new boolean[N][N]; // 현재 먹을 수 있는 물고기를 찾아서 먹었으므로, 또 다음번 물고기를 찾기 위해 방문했던 위치 초기화.
        }

        System.out.println(result);
    }

    private static void sizeUpAndInitCount() {
        if (shark.size == shark.eatCount) {
            shark.size++;
            shark.eatCount = 0;
        }
    }

    private static void eatFish(Fish target) {
        shark.x = target.x;
        shark.y = target.y;
        map[shark.x][shark.y] = 0;
        shark.eatCount++;
    }

    private static Fish findTarget() {
        Fish target = null;
        Queue<Fish> queue = new LinkedList<>();
        queue.offer(new Fish(shark.x, shark.y, 0)); // 상어의 현재 위치, 거리는 현 위치이므로 0 상태.
        visited[shark.x][shark.y] = true; // 현재위치로 다시 되돌아오지 않도록 방문처리.

        while (!queue.isEmpty()) {
            Fish current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx < 0 || ny < 0 || N <= nx || N <= ny || visited[nx][ny]) continue;
                if (map[nx][ny] == 0 || shark.size == map[nx][ny]) { // 다음 위치가 빈 공간이거나 상어와 같은 사이즈의 물고기면 방문처리.
                    visited[nx][ny] = true;
                    queue.offer(new Fish(nx, ny, current.distance + 1));
                } else if (map[nx][ny] < shark.size) { // 상어보다 작은 사이즈의 물고기일 때.
                    // 아직 찾은 물고기가 없거나, 먼저 찾은 target 이동거리와 현재 이동거리 + 1이 같고
                    // 다음 위치 nx가 먼저 찾은 target.x보다 작거나, 다음위치 nx가 target.x와 같고 다음위치 ny가 target.y 보다 작은 경우
                    // 새로 찾은 nx, ny가 더 가까운 물고기라고 판별.
                    if (target == null || (target.distance == current.distance + 1 && (nx < target.x || (nx == target.x && ny < target.y)))) {
                        target = new Fish(nx, ny, current.distance + 1);
                    }
                }
            }
        }
        return target;
    }

    private static void setMap(BufferedReader br) throws IOException {
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    shark = new Shark(i, j);
                    map[i][j] = 0;
                }
            }
        }
    }
}
