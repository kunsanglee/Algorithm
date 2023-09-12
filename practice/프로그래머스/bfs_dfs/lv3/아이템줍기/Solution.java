package practice.프로그래머스.bfs_dfs.lv3.아이템줍기;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    static int[][] map;
    static boolean[][] visited;
    static List<Rec> recs = new ArrayList<>();
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int targetX;
    static int targetY;

    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        targetX = itemX * 2;
        targetY = itemY * 2;
        map = new int[102][102];
        visited = new boolean[102][102];
        for (int[] rec : rectangle) {
            recs.add(new Rec(rec[0], rec[1], rec[2], rec[3]));
        }

        for (Rec rec : recs) {
            setMap(rec);
        }

        queue.offer(new int[]{characterX * 2, characterY * 2, 0});
        visited[characterY * 2][characterX * 2] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0];
            int cy = curr[1];

            if (cx == targetX && cy == targetY) {
                return curr[2] / 2;
            }

            for (int i = 0; i < dx.length; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (!visited[ny][nx] && map[ny][nx] == 1) {
                    queue.offer(new int[]{nx, ny, curr[2] + 1});
                    visited[ny][nx] = true;
                }
            }
        }
        return -1;
    }

    public static void setMap(Rec rec) {
        for (int i = rec.y1; i <= rec.y2; i++) {
            for (int j = rec.x1; j <= rec.x2; j++) {
                if (!isIn(j, i)) {
                    map[i][j] = 1;
                }
            }
        }
    }

    public static boolean isIn(int x, int y) {
        for (Rec rec : recs) {
            if (rec.x1 < x && x < rec.x2 && rec.y1 < y && y < rec.y2) {
                return true;
            }
        }
        return false;
    }

    static class Rec {
        private int x1;
        private int y1;
        private int x2;
        private int y2;

        public Rec(int x1, int y1, int x2, int y2) {
            this.x1 = x1 * 2;
            this.y1 = y1 * 2;
            this.x2 = x2 * 2;
            this.y2 = y2 * 2;
        }
    }
}
