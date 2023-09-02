package practice.BOJ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_2178_bfs_maze_search {

    static ArrayList<Node> needVisited = new ArrayList<>();
    static int[][] visited;
    static int[][] maze;
    static int[] yDirection = {-1, 1, 0, 0};
    static int[] xDirection = {0, 0, -1, 1};

    static class Node {
        public int x;
        public int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        maze = new int[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();
            for (int j = 0; j < m; j++) {
                maze[i][j] = Character.getNumericValue(tmp.charAt(j));
            }
        }

        bfsFunc(0, 0);
        System.out.println(maze[n-1][m-1]);
    }

    private static void bfsFunc(int xStart, int yStart) {
        needVisited.add(new Node(xStart, yStart));
        visited[xStart][yStart] = 1;

        while (needVisited.size() > 0) {
            Node removed = needVisited.remove(0);
            for (int i = 0; i < 4; i++) {
                int nextX = removed.x + xDirection[i];
                int nextY = removed.y + yDirection[i];
                if (positionCheck(nextX, nextY) &&
                        maze[nextX][nextY] == 1 &&
                        visited[nextX][nextY] == 0) {
                    visited[nextX][nextY] = 1;
                    needVisited.add(new Node(nextX, nextY));
                    maze[nextX][nextY] += maze[removed.x][removed.y];
                }
            }
        }
    }

    private static boolean positionCheck(int nextX, int nextY) {
        if (0 <= nextX && nextX < maze.length &&
        0 <= nextY && nextY < maze[0].length) return true;
        else return false;
    }
}
