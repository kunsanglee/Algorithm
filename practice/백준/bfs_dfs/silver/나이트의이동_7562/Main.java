package practice.백준.bfs_dfs.silver.나이트의이동_7562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] move = {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        while (N > 0) {
            int I = Integer.parseInt(br.readLine());
            int[][] visited = new int[I][I];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int currentY = Integer.parseInt(st.nextToken());
            int currentX = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int targetY = Integer.parseInt(st.nextToken());
            int targetX = Integer.parseInt(st.nextToken());
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{currentY, currentX});
            visited[currentY][currentX] = 1;
            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                if (current[0] == targetY && current[1] == targetX) {
                    break;
                }
                for (int i = 0; i < move.length; i++) {
                    int ny = current[0] + move[i][0];
                    int nx = current[1] + move[i][1];
                    if (ny < 0 || nx < 0 || I <= ny || I <= nx || visited[ny][nx] != 0) continue;
                    queue.offer(new int[]{ny, nx});
                    visited[ny][nx] = visited[current[0]][current[1]] + 1;
                }
            }
            System.out.println(visited[targetY][targetX] - 1);
            N--;
        }
    }
}
