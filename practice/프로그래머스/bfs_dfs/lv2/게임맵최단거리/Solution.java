package practice.프로그래머스.bfs_dfs.lv2.게임맵최단거리;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visited;

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        visited = new boolean[n][m];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                if (nx < 0 || ny < 0 || m <= nx || n <= ny) continue;
                if (visited[ny][nx] || maps[ny][nx] == 0) continue;

                queue.offer(new int[]{nx, ny});
                visited[ny][nx] = true;
                maps[ny][nx] = maps[curr[1]][curr[0]] + 1;
            }
        }
        return maps[n - 1][m - 1] == 1 ? -1 : maps[n - 1][m - 1];
    }
}
