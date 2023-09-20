package practice.백준.bfs_dfs.gold.적록색약_10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static char[][] map, blindMap;
    static boolean[][] visited;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new char[N][N]; // 정상맵
        blindMap = new char[N][N]; // 색약맵
        visited = new boolean[N][N];
        setMap(br);
        int normalCount = bfs(false); // 정상 count
        removeVisited();
        int blindCount = bfs(true); // 색약 count

        System.out.println(normalCount + " " + blindCount);
    }

    private static void removeVisited() {
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }
    }

    private static int bfs(boolean isBlind) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) { // 방문하지 않았다면 bfs
                    queue.add(new int[]{i, j});
                    char currentColor = isBlind ? blindMap[i][j] : map[i][j]; // 만약 색약이라면 색약맵에서 읽고, 정상인이라면 정상맵에서 읽는다.
                    while (!queue.isEmpty()) {
                        int[] poll = queue.poll();
                        int y = poll[0];
                        int x = poll[1];
                        visited[y][x] = true;
                        for (int k = 0; k < 4; k++) {
                            int ny = y + dy[k];
                            int nx = x + dx[k];
                            if (0 <= ny && ny < N && 0 <= nx && nx < N && !visited[ny][nx]) { // 맵 범위에서 넘어가지 않으면 만족.
                                if (isBlind && blindMap[ny][nx] == currentColor || !isBlind && map[ny][nx] == currentColor) { // 색약 -> 색약맵 비교, 정상 -> 정상맵 비교.
                                    queue.add(new int[]{ny, nx});
                                    visited[ny][nx] = true;
                                }
                            }
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }

    private static void setMap(BufferedReader br) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String colors = st.nextToken();
            for (int j = 0; j < N; j++) {
                char color = colors.charAt(j);
                map[i][j] = color; // 정상인이 보는 색깔로된 맵
                blindMap[i][j] = color == 'G' ? 'R' : color; // 색약인이 보는 색깔로된 맵 -> G를 R과 동일하게 R로 표시.
            }
        }
    }
}
