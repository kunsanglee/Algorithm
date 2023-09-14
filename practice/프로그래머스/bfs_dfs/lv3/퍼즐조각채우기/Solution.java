package practice.프로그래머스.bfs_dfs.lv3.퍼즐조각채우기;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static boolean[][] holeVisited;
    static boolean[][] partVisited;
    static Queue<int[]> holeQueue = new LinkedList<>();
    static Queue<int[]> partQueue = new LinkedList<>();
    static ArrayList<ArrayList<int[]>> holes = new ArrayList<>();
    static ArrayList<ArrayList<int[]>> parts = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int col, row;
    public int solution(int[][] game_board, int[][] table) {
        //1) DFS or BFS 를 이용하여 좌표탐색을 한다 - 조각 모음을 좌표로 저장한다
        //2) 받은 좌표들을 사각형 형태로 가공한다.
        //3) 사각형 형태의 가공물들을 90도 회전하는 함수를 만든다.
        //4) 비교 및 검사
        col = table.length;
        row = table[0].length;
        partVisited = new boolean[col][row];
        holeVisited = new boolean[col][row];

        make(game_board, holeVisited, holeQueue, holes, 0);
        make(table, partVisited, partQueue, parts, 1);

        // 이제 parts 들을 제일 긴 행열 기준으로 사각형으로 만든다.
        // 그 만들어진 사각형 파츠들을 리스트로 저장한다.
        // game_board 의 빈칸들을 bfs 로 추출한다.
        // 빈칸과 각 파츠를 회전시키면서 비교한다.
        // 일치하는것이 더이상 없을 때 까지 total 을 증가시키고 반환한다.



        return 1;
    }

    private void make(int[][] board, boolean[][] visited, Queue<int[]> queue, ArrayList<ArrayList<int[]>> list, int target) {
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (!visited[i][j] && board[i][j] == target) {
                    queue.offer(new int[]{j, i});
                    visited[i][j] = true;
                    ArrayList<int[]> part = new ArrayList<>();
                    part.add(new int[]{j, i});
                    bfs(board, part);
                    list.add(part);
                    visited[i][j] = false;
                }
            }
        }
    }

    private void bfs(int[][] table, ArrayList<int[]> part) {
        while (!partQueue.isEmpty()) {
            int[] curr = partQueue.poll();
            int x = curr[0];
            int y = curr[1];
            for (int i = 0; i < dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && 0 <= ny && nx < row && ny < col) {
                    if (!partVisited[ny][nx] && table[ny][nx] == 1) {
                        partVisited[ny][nx] = true;
                        part.add(new int[]{nx, ny});
                        partQueue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
